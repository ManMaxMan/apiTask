package com.github.ManMaxMan.TasAPI.dao;


import com.github.ManMaxMan.TasAPI.core.dto.MessageDTO;
import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.dao.api.IMessageDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MessageDao implements IMessageDao {

    private final Map<String, List<MessageDTO>> fromUser = new HashMap<>();
    private final Map<String, List<MessageDTO>> forUser = new HashMap<>();

    @Override
    public List<MessageDTO> list(UserDTO forUser) {
        return this.forUser.get(forUser.getLogin());
    }

    @Override
    public void create(MessageDTO dto) {
        List<MessageDTO> fromList = this.fromUser.getOrDefault(dto.getFrom(), new ArrayList<>());
        fromList.add(dto);
        this.fromUser.put(dto.getFrom(), fromList);
        List<MessageDTO> forList = this.forUser.getOrDefault(dto.getTo(), new ArrayList<>());
        forList.add(dto);
        this.forUser.put(dto.getTo(), forList);
    }
}
