package com.github.ManMaxMan.TasAPI.dao.api;

import com.github.ManMaxMan.TasAPI.core.dto.StatisticDTO;

public interface IStatisticDao {
    StatisticDTO get();
    void addUser();
    void addActiveUser();
    void addMessage();
    void removeUser();
    void removeActiveUser();
    void removeMessage();
}
