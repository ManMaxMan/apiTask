package com.github.ManMaxMan.TasAPI.dao.api;


import com.github.ManMaxMan.TasAPI.core.dto.MessageDTO;
import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;

import java.util.List;

public interface IMessageDao {

    List<MessageDTO> list(UserDTO forUser);

    void create(MessageDTO dto);
}
