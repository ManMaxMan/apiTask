package com.github.ManMaxMan.TasAPI.service.dto;

import java.time.LocalDate;

public class RegistrationUserDTOBuilder {

    private String login;
    private String password;
    private String name;
    private LocalDate birthday;

    private RegistrationUserDTOBuilder(){

    }

    public static RegistrationUserDTOBuilder builder (){
        return new RegistrationUserDTOBuilder();
    }

    public RegistrationUserDTOBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public RegistrationUserDTOBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public RegistrationUserDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RegistrationUserDTOBuilder setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public RegistrationUserDTO build(){
        return new RegistrationUserDTO(login, password, name, birthday);
    }
}
