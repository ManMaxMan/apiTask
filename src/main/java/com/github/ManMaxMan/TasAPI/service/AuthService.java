package com.github.ManMaxMan.TasAPI.service;

import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.service.api.IAuthService;
import com.github.ManMaxMan.TasAPI.service.api.IUsersService;
import com.github.ManMaxMan.TasAPI.service.dto.LoginDTO;

import java.util.Optional;

public class AuthService implements IAuthService {

    private static final String WRONG_LOGIN_OR_PASSWORD = "Логин или пароль неверны";

    private final IUsersService userService;

    public AuthService(IUsersService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO login(LoginDTO login) {
        Optional<UserDTO> optional = this.userService.getByLogin(login.getLogin());

        if(optional.isEmpty()){
            throw new IllegalArgumentException(WRONG_LOGIN_OR_PASSWORD);
        }

        UserDTO userDTO = optional.get();

        if(!userDTO.getPassword().equals(login.getPassword())){
            throw new IllegalArgumentException(WRONG_LOGIN_OR_PASSWORD);
        }

        return userDTO;
    }
}
