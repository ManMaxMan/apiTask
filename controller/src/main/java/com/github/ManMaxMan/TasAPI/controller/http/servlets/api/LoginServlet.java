package com.github.ManMaxMan.TasAPI.controller.http.servlets.api;


import com.github.ManMaxMan.TasAPI.controller.http.utils.SessionUtils;
import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.service.api.IAuthService;
import com.github.ManMaxMan.TasAPI.service.dto.LoginDTO;
import com.github.ManMaxMan.TasAPI.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {

    private final static String LOGIN = "login";
    private final static String PASSWORD = "password";

    private final IAuthService authService = ServiceFactory.getAuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        LoginDTO dto = new LoginDTO(login, password);

        PrintWriter writer = resp.getWriter();

        try{
            UserDTO userDTO = this.authService.login(dto);

            SessionUtils.saveUser(req.getSession(),userDTO);

        } catch (IllegalArgumentException e){
            writer.write(e.getMessage());
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
