package org.app.TaskAPI.dao;

import org.app.TaskAPI.dao.api.dto.User;
import org.app.TaskAPI.dao.api.dto.enums.ERoles;
import org.app.TaskAPI.dao.api.interfaces.IUsersDao;


import java.text.SimpleDateFormat;
import java.util.*;

public class UsersDao implements IUsersDao {

    private final Set<User> usersRepository;

    public UsersDao(){
        usersRepository = new HashSet<>();
        usersRepository.add(new User("admin", "123123", "admin", "1900-01-01",
                "1900-01-01", ERoles.ADMIN));
    }

    @Override
    public void create(String login, String pass, String fio, String birthday){
        User newUser = new User();
        newUser.setLogin(login);
        newUser.setPassword(pass);
        newUser.setFIO(fio);
        newUser.setBirthday(birthday);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarNow = Calendar.getInstance();
        newUser.setRegistrationDate(sdf.format(calendarNow.getTime()));

        newUser.setRole(ERoles.USER);
        usersRepository.add(newUser);
    }

    @Override
    public User getByLoginPassword(String login, String pass) {
        return null;
    }

    @Override
    public Set<User> getAll() {
        return usersRepository;
    }
}
