package com.github.ManMaxMan.TasAPI.service.factory;


import com.github.ManMaxMan.TasAPI.service.api.IAuthService;
import com.github.ManMaxMan.TasAPI.service.api.IMessageService;
import com.github.ManMaxMan.TasAPI.service.api.IStatisticService;
import com.github.ManMaxMan.TasAPI.service.api.IUsersService;
import com.github.ManMaxMan.TasAPI.dao.factory.DaoFactory;
import com.github.ManMaxMan.TasAPI.service.*;

public class ServiceFactory {

    private volatile static IUsersService usersService;
    private volatile static IAuthService authService;
    private volatile static IMessageService messageService;
    private volatile static IStatisticService statisticService;

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
                    messageService = new MessageService(DaoFactory.getMessageDao(),getUsersService());
                }
            }
        }
        return messageService;
    }

    public static IStatisticService getStatisticService(){
        if(statisticService == null){
            synchronized (ServiceFactory.class){
                if(statisticService == null){
                    statisticService = new StatisticService(DaoFactory.getStatisticDao());
                }
            }
        }
        return statisticService;
    }
}
