package com.github.ManMaxMan.TasAPI.service;

import com.github.ManMaxMan.TasAPI.core.dto.MessageDTO;
import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.dao.api.IMessageDao;
import com.github.ManMaxMan.TasAPI.service.api.IMessageService;
import com.github.ManMaxMan.TasAPI.service.api.IUsersService;
import com.github.ManMaxMan.TasAPI.service.dto.SendMessageDTO;
import com.github.ManMaxMan.TasAPI.core.dto.MessageDTOBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MessageService implements IMessageService {

    private final IMessageDao dao;
    private final IUsersService userService;

    public MessageService(IMessageDao dao, IUsersService userService) {
        this.dao = dao;
        this.userService = userService;
    }

    @Override
    public List<MessageDTO> list(UserDTO forUser) {
        if(isExistsUser(forUser.getLogin())){
            return this.dao.list(forUser);
        }else {
            throw new IllegalArgumentException("Подозрительная активность!");
        }
    }

    @Override
    public void create(UserDTO from, SendMessageDTO dto) {

        if (!isExistsUser(from.getLogin())||!isExistsUser(dto.getTo())){
            throw new IllegalArgumentException("Подозрительная активность!");
        }

        MessageDTO create = MessageDTOBuilder.builder()
                .setFrom(from.getLogin())
                .setTo(dto.getTo())
                .setBody(dto.getText())
                .setLocalDateTime(LocalDateTime.now())
                .build();

        this.dao.create(create);
    }

    @Override
    public Boolean isExistsUser(String login) {
        Optional<UserDTO> optional = this.userService.getByLogin(login);
        return optional.isPresent();
    }

}
