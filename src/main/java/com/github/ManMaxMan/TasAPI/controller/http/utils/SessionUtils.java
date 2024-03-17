package com.github.ManMaxMan.TasAPI.controller.http.utils;

import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import jakarta.servlet.http.HttpSession;

public class SessionUtils {

    private final static String USER_ATTRIBUTE = "user";

    public static void saveUser(HttpSession session, UserDTO dto){
        if(session == null){
            throw new IllegalStateException("Сессия не создана");
        }

        session.setAttribute(USER_ATTRIBUTE, dto);
    }

    public static UserDTO loadUser(HttpSession session){
        if(session == null){
            return null;
        }

        Object attribute = session.getAttribute(USER_ATTRIBUTE);

        if(attribute == null){
            return null;
        }

        return (UserDTO) attribute;
    }
}
