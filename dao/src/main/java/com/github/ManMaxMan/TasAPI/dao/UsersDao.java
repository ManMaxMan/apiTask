package com.github.ManMaxMan.TasAPI.dao;


import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.core.enums.ERoles;
import com.github.ManMaxMan.TasAPI.dao.api.IUsersDao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class UsersDao implements IUsersDao {

    private final Map<String, UserDTO> usersRepository = new HashMap<>();

    public UsersDao(){
        usersRepository.put("admin", new UserDTO("admin", "123123", "admin", LocalDate.now(),
                LocalDateTime.now(), ERoles.ADMIN));
    }

    @Override
    public void create(UserDTO user) {
        if(this.usersRepository.containsKey(user.getLogin())){
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }

        this.usersRepository.put(user.getLogin(), user);
    }

    @Override
    public Optional<UserDTO> getByLogin(String login) {
        return Optional.ofNullable(this.usersRepository.get(login));
    }


}
