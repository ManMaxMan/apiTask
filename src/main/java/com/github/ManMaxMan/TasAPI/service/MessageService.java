package com.github.ManMaxMan.TasAPI.service;

import com.github.ManMaxMan.TasAPI.core.dto.MessageDTO;
import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.service.api.IMessageService;
import com.github.ManMaxMan.TasAPI.service.api.IUsersService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MessageService implements IMessageService {

    private final IUsersService userService;

    public MessageService (IUsersService userService) {
        this.userService = userService;
    }

    @Override
    public List<MessageDTO> getMailFromUser(UserDTO userDTO) {

        if (isExistsUser(userDTO.getLogin())){
            return userService.getByLogin(userDTO.getLogin()).get().getMessagesList();
        }else {
            throw new IllegalArgumentException("Подозрительная активность!");
        }

    }

    @Override
    public void postToUser(MessageDTO messageDTO) {

        if (isExistsUser(messageDTO.getFrom()) && isExistsUser(messageDTO.getTo())){
            messageDTO.setLocalDateTime(LocalDateTime.now());
            userService.getByLogin(messageDTO.getTo()).get().getMessagesList().add(messageDTO);
        }else {
            throw new IllegalArgumentException("Подозрительная активность!");
        }

    }

    @Override
    public Boolean isExistsUser(String login) {
        Optional<UserDTO> optional = this.userService.getByLogin(login);
        return optional.isPresent();
    }

}
