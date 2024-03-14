package com.github.ManMaxMan.TasAPI.service;

import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.core.enums.ERoles;
import com.github.ManMaxMan.TasAPI.dao.api.IUsersDao;
import com.github.ManMaxMan.TasAPI.service.api.IUsersService;
import com.github.ManMaxMan.TasAPI.service.dto.RegistrationUserDTO;
import com.github.ManMaxMan.TasAPI.service.utils.ValidateFieldUtil;

import java.time.LocalDateTime;
import java.util.Optional;


public class UsersService implements IUsersService {

    private final IUsersDao usersDao;

    public UsersService(IUsersDao usersDao) {
        this.usersDao = usersDao;
    }


    @Override
    public void create(RegistrationUserDTO registrationUserDTO) {

        UserDTO user = new UserDTO();
        user.setLogin(registrationUserDTO.getLogin());
        user.setPassword(registrationUserDTO.getPassword());
        user.setFIO(registrationUserDTO.getName());
        user.setBirthday(registrationUserDTO.getBirthday());
        user.setRole(ERoles.USER);

        create(user);
    }

    @Override
    public void create(UserDTO userDTO) {

        ValidateFieldUtil validateFieldUtil = new ValidateFieldUtil(userDTO);
        validateFieldUtil.login();
        validateFieldUtil.password();
        validateFieldUtil.fio();

        Optional<UserDTO> byLogin = this.usersDao.getByLogin(userDTO.getLogin());
        if(byLogin.isPresent()){
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }

        userDTO.setRegistrationDate(LocalDateTime.now());

        this.usersDao.create(userDTO);
    }

    @Override
    public Optional<UserDTO> getByLogin(String login) {
        return this.usersDao.getByLogin(login);
    }


}
