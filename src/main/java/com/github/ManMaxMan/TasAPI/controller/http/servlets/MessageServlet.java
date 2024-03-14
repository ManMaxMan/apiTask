package com.github.ManMaxMan.TasAPI.controller.http.servlets;

import com.github.ManMaxMan.TasAPI.core.dto.MessageDTO;
import com.github.ManMaxMan.TasAPI.core.dto.MessageDTOBuilder;
import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.service.api.IMessageService;
import com.github.ManMaxMan.TasAPI.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {

    private static final String RECIPIENT = "recipient";
    private static final String BODY_MESSAGE = "body";

    private final IMessageService messageService = ServiceFactory.getMessageService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession(false);
        UserDTO currentUser = (UserDTO) session.getAttribute("user");
        if (currentUser==null){
            writer.write("<p>Авторизуйтесь в системе!</p>");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }else {

            List<MessageDTO> messageList;
            try {
                messageList = messageService.getMailFromUser(currentUser);
            }catch (IllegalArgumentException e){
                writer.write("<p>" + e.getMessage()+"</p>");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            writer.write("<p>Ваши сообщения:</p>");
            messageList.forEach(message->{
                writer.write("<br>"+message+"</br>");
            });
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession(false);
        UserDTO currentUser = (UserDTO) session.getAttribute("user");
        if (currentUser==null){
            writer.write("<p>Авторизуйтесь в системе!</p>");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }else {
            try {
                messageService.postToUser(MessageDTOBuilder.builder()
                        //.setLocalDateTime(LocalDateTime.now())
                        .setFrom(currentUser.getLogin())
                        .setTo(RECIPIENT)
                        .setBody(BODY_MESSAGE).build());
            }catch (IllegalArgumentException e){
                writer.write("<p>" + e.getMessage()+"</p>");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            writer.write("<p>Сообщение успешно отправлено!</p>");
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
