package com.github.ManMaxMan.TasAPI.dao.factory;

import com.github.ManMaxMan.TasAPI.dao.MessageDao;
import com.github.ManMaxMan.TasAPI.dao.UsersDao;
import com.github.ManMaxMan.TasAPI.dao.api.IMessageDao;
import com.github.ManMaxMan.TasAPI.dao.api.IUsersDao;

public class DaoFactory {

    private volatile static IUsersDao UsersDao;
    private volatile static IMessageDao messageDao;

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
    public static IMessageDao getMessageDao(){
        if(messageDao == null){
            synchronized (DaoFactory.class){
                if(messageDao == null){
                    messageDao = new MessageDao();
                }
            }
        }
        return messageDao;
    }
}
