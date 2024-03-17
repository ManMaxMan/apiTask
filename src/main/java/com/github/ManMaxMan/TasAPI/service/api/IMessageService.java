package com.github.ManMaxMan.TasAPI.service.api;

import com.github.ManMaxMan.TasAPI.core.dto.MessageDTO;
import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.service.dto.SendMessageDTO;

import java.util.List;

public interface IMessageService {
    List<MessageDTO> list(UserDTO forUser);

    void create(UserDTO from, SendMessageDTO dto);
    Boolean isExistsUser (String login);

}
