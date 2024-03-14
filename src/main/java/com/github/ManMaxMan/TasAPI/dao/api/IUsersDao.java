package com.github.ManMaxMan.TasAPI.dao.api;

import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import java.util.Optional;

public interface IUsersDao {

    void create(UserDTO user);
    Optional<UserDTO> getByLogin(String login);
}
