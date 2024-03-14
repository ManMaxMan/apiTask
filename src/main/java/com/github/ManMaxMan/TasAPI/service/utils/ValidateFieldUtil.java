package com.github.ManMaxMan.TasAPI.service.utils;

import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;

public class ValidateFieldUtil {

    private UserDTO userDTO;

    public ValidateFieldUtil(UserDTO userDTO){
        this.userDTO=userDTO;
    }

    /**
     * валидация логина по длине, регулярному выражению  и др
     */
    public void login (){
        if (userDTO.getLogin()==null||userDTO.getLogin().length()<3) {
            throw new IllegalArgumentException("Логин некорректен!");
        }
    }

    /**
     * валидация пароля по заданным правилам
     */
    public void password (){
        if (userDTO.getPassword()==null||userDTO.getPassword().length()<3) {
            throw new IllegalArgumentException("Пароль не удовлетворяет политике безопасности!");
        }
    }

    /**
     * валидация ФИО по заданным правилам
     */
    public void fio (){
        if (userDTO.getFIO()==null||userDTO.getFIO().length()<3) {
            throw new IllegalArgumentException("ФИО некорректны!");
        }
    }
}
