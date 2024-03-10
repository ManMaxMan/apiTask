package org.app.TaskAPI.dao.factory;

import org.app.TaskAPI.dao.UsersDao;
import org.app.TaskAPI.dao.api.interfaces.IUsersDao;

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
