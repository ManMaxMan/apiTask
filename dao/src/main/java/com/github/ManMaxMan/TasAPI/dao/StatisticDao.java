package com.github.ManMaxMan.TasAPI.dao;

import com.github.ManMaxMan.TasAPI.core.dto.StatisticDTO;
import com.github.ManMaxMan.TasAPI.dao.api.IStatisticDao;

public class StatisticDao implements IStatisticDao {

    private volatile Long users;
    private volatile Long activeUsers;
    private volatile Long  messages;

    public StatisticDao(){
        this.messages = 0L;
        this.users = 0L;
        this.activeUsers=0L;
    }

    @Override
    public synchronized StatisticDTO get() {
        return StatisticDTO.builder().users(this.users).messages(this.messages).activeUsers(this.activeUsers).build();
    }

    @Override
    public synchronized void addUser() {
        this.users++;
    }

    @Override
    public synchronized void addActiveUser() {
        this.activeUsers++;
    }

    @Override
    public synchronized void addMessage() {
        this.messages++;
    }

    @Override
    public synchronized void removeUser() {
        this.users--;
    }

    @Override
    public synchronized void removeActiveUser() {
        this.activeUsers--;
    }

    @Override
    public synchronized void removeMessage() {
        this.messages--;
    }
}
