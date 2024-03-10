package org.app.TaskAPI.service.factory;

import org.app.TaskAPI.dao.factory.DaoFactory;
import org.app.TaskAPI.service.UsersService;
import org.app.TaskAPI.service.api.interfaces.IUsersService;

public class ServiceFactory {

    private volatile static IUsersService usersService;

    public static IUsersService getUsersService(){
        if (usersService==null){
            synchronized (ServiceFactory.class){
                if (usersService==null){
                    usersService= new UsersService(DaoFactory.getUsersDao());
                }
            }
        }
        return usersService;
    }
}
