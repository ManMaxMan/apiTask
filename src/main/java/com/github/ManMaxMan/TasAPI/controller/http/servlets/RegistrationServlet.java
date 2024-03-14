package com.github.ManMaxMan.TasAPI.controller.http.servlets;

import com.github.ManMaxMan.TasAPI.service.dto.RegistrationUserDTO;
import com.github.ManMaxMan.TasAPI.service.dto.RegistrationUserDTOBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.github.ManMaxMan.TasAPI.service.api.IUsersService;
import com.github.ManMaxMan.TasAPI.service.factory.ServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@WebServlet(urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    private final static String LOGIN = "login";
    private final static String PASSWORD = "password";
    private final static String FIO = "fio";
    private final static String BIRTHDAY = "birthday";

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final IUsersService usersService = ServiceFactory.getUsersService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String fio = req.getParameter(FIO);
        String birthday = req.getParameter(BIRTHDAY);
        LocalDate birthdayDate;

        PrintWriter writer = resp.getWriter();

        try {
            birthdayDate = LocalDate.parse(birthday, formatter);
        }catch (DateTimeParseException dateTimeParseException){
            writer.write("<p>Ошибка в переданной дате. Передавайте в формате yyyy-MM-dd</p>");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        RegistrationUserDTO user = RegistrationUserDTOBuilder.builder()
                .setLogin(login)
                .setPassword(password)
                .setName(fio)
                .setBirthday(birthdayDate)
                .build();

        try {
            usersService.create(user);
            writer.write("<p>Пользователь создан успешно!</p>");
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }catch (IllegalArgumentException exception){
            writer.write("<p>Ошибка: " + exception.getMessage()+"</p>");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
