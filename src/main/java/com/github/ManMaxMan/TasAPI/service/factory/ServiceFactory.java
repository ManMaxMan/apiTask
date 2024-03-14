package com.github.ManMaxMan.TasAPI.service.factory;


import com.github.ManMaxMan.TasAPI.dao.factory.DaoFactory;
import com.github.ManMaxMan.TasAPI.service.AuthService;
import com.github.ManMaxMan.TasAPI.service.MessageService;
import com.github.ManMaxMan.TasAPI.service.UsersService;
import com.github.ManMaxMan.TasAPI.service.api.IAuthService;
import com.github.ManMaxMan.TasAPI.service.api.IMessageService;
import com.github.ManMaxMan.TasAPI.service.api.IUsersService;


public class ServiceFactory {

    private volatile static IUsersService usersService;
    private volatile static IAuthService authService;
    private volatile static IMessageService messageService;

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

    public static IAuthService getAuthService(){
        if(authService == null){
            synchronized (ServiceFactory.class){
                if(authService == null){
                    authService = new AuthService(getUsersService());
                }
            }
        }
        return authService;
    }

    public static IMessageService getMessageService(){
        if(messageService == null){
            synchronized (ServiceFactory.class){
                if(messageService == null){
                    messageService = new MessageService(getUsersService());
                }
            }
        }
        return messageService;
    }
}
