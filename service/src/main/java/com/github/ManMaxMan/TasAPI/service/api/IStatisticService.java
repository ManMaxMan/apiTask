package com.github.ManMaxMan.TasAPI.service.api;

import com.github.ManMaxMan.TasAPI.core.dto.StatisticDTO;

public interface IStatisticService {
    StatisticDTO get();
    void addUser();
    void addActiveUser();
    void addMessage();
    void removeUser();
    void removeActiveUser();
    void removeMessage();
}
