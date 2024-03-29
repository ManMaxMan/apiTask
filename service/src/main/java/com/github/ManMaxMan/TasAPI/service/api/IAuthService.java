package com.github.ManMaxMan.TasAPI.service.api;

import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.service.dto.LoginDTO;


public interface IAuthService {
    UserDTO login(LoginDTO login);
}
