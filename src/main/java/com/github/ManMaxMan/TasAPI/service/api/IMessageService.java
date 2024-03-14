package com.github.ManMaxMan.TasAPI.service.api;

import com.github.ManMaxMan.TasAPI.core.dto.MessageDTO;
import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;

import java.util.List;

public interface IMessageService {
    List<MessageDTO> getMailFromUser(UserDTO userDTO);
    void postToUser(MessageDTO messageDTO);
    Boolean isExistsUser (String login);

}
