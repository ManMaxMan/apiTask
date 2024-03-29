package com.github.ManMaxMan.TasAPI.service.api;

import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.service.dto.RegistrationUserDTO;

import java.util.Optional;

public interface IUsersService {

    /**
     * Создание пользователя при регистрации
     * @param registrationUserDTO
     */
    void create(RegistrationUserDTO registrationUserDTO);

    /**
     * Создание пользователя в системе
     * @param userDTO
     */
    void create(UserDTO userDTO);

    /**
     * Получение пользователя по логину
     * @param login
     * @return
     */
    Optional<UserDTO> getByLogin(String login);

}
