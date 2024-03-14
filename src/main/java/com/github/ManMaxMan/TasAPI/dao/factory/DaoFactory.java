package com.github.ManMaxMan.TasAPI.dao.factory;

import com.github.ManMaxMan.TasAPI.dao.UsersDao;
import com.github.ManMaxMan.TasAPI.dao.api.IUsersDao;

public class DaoFactory {

    private volatile static IUsersDao UsersDao;

    public static IUsersDao getUsersDao(){
        if(UsersDao == null){
            synchronized (DaoFactory.class){
                if(UsersDao == null){
                    UsersDao = new UsersDao();
                }
            }
        }
        return UsersDao;
    }
}
