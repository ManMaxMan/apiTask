package com.github.ManMaxMan.TasAPI.controller.http.listeners;

import com.github.ManMaxMan.TasAPI.controller.http.utils.SessionUtils;
import com.github.ManMaxMan.TasAPI.service.api.IStatisticService;
import com.github.ManMaxMan.TasAPI.service.factory.ServiceFactory;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class UsersActivityListener implements HttpSessionAttributeListener {

    private final IStatisticService statisticService= ServiceFactory.getStatisticService();

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {

        if (SessionUtils.loadUser(se.getSession())!=null){
            statisticService.addActiveUser();
        }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        if (SessionUtils.loadUser(se.getSession())!=null){
            statisticService.removeActiveUser();
        }
    }
}
