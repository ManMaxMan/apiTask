package org.app.TaskAPI.dao.api.interfaces;

import org.app.TaskAPI.dao.api.dto.User;

import java.text.ParseException;
import java.util.Set;

public interface IUsersDao {

    void create(String login, String pass, String fio, String birthday);

    User getByLoginPassword (String login, String pass);

    Set<User> getAll();
}
