package org.app.TaskAPI.controller.http.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.TaskAPI.service.api.interfaces.IUsersService;
import org.app.TaskAPI.service.factory.ServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    private final static String LOGIN = "login";
    private final static String PASSWORD = "password";
    private final static String FIO = "fio";
    private final static String BIRTHDAY = "birthday";

    private IUsersService usersService = ServiceFactory.getUsersService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String fio = req.getParameter(FIO);
        String birthday = req.getParameter(BIRTHDAY);

        PrintWriter writer = resp.getWriter();
        try {
            usersService.create(login, password, fio, birthday);
            writer.write("<p>Пользователь создан успешно!</p>");
        }catch (IllegalArgumentException exception){
            writer.write(exception.getMessage());
        }
    }


}
