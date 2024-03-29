package com.github.ManMaxMan.TasAPI.service;

import com.github.ManMaxMan.TasAPI.core.dto.StatisticDTO;
import com.github.ManMaxMan.TasAPI.dao.api.IStatisticDao;
import com.github.ManMaxMan.TasAPI.service.api.IStatisticService;

public class StatisticService implements IStatisticService {

    private final IStatisticDao statisticDao;

    public StatisticService(IStatisticDao statisticDao){
        this.statisticDao=statisticDao;
    }

    @Override
    public StatisticDTO get() {
        return statisticDao.get();
    }

    @Override
    public void addUser() {
        statisticDao.addUser();
    }

    @Override
    public void addActiveUser() {
        statisticDao.addActiveUser();
    }

    @Override
    public void addMessage() {
        statisticDao.addMessage();
    }

    @Override
    public void removeUser() {
        statisticDao.removeUser();
    }

    @Override
    public void removeActiveUser() {
        statisticDao.removeActiveUser();
    }

    @Override
    public void removeMessage() {
        statisticDao.removeMessage();
    }
}
