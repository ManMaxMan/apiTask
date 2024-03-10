package org.app.TaskAPI.service;

import org.app.TaskAPI.dao.api.interfaces.IUsersDao;
import org.app.TaskAPI.service.api.interfaces.IUsersService;

public class UsersService implements IUsersService {

    private final IUsersDao usersDao;

    public UsersService(IUsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public void create(String login, String pass, String fio, String birthday){
        if (login==null||pass==null||fio==null||birthday==null){
            throw new IllegalArgumentException("Заполнены не все параметры!");
        }

        if(usersDao.getAll().stream().anyMatch(u->u.getLogin().equals(login))){
            throw new IllegalArgumentException("Пользователь с таким логином уже существует!");
        }

        usersDao.create(login, pass, fio, birthday);
    }
}
