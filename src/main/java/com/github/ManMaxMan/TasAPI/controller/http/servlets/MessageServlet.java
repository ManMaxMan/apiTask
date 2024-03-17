package com.github.ManMaxMan.TasAPI.controller.http.servlets;

import com.github.ManMaxMan.TasAPI.controller.http.utils.SessionUtils;
import com.github.ManMaxMan.TasAPI.core.dto.MessageDTO;
import com.github.ManMaxMan.TasAPI.core.dto.MessageDTOBuilder;
import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.service.api.IMessageService;
import com.github.ManMaxMan.TasAPI.service.dto.SendMessageDTO;
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

    private static final String TO_PARAMETER_NAME = "to";
    private static final String TEXT_PARAMETER_NAME = "text";

    private final IMessageService messageService = ServiceFactory.getMessageService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        List<MessageDTO> messages;
        try {
            messages = this.messageService.list(SessionUtils.loadUser(req.getSession()));
        }catch (IllegalArgumentException e){
            writer.write(e.getMessage());
            return;
        }

        if(messages != null){
            for (MessageDTO message : messages) {
                writer.write("<p>Дата отправки: " + message.getLocalDateTime() + "</p>");
                writer.write("<p>От кого: " + message.getFrom() + "</p>");
                writer.write("<p>Текст: " + message.getBody() + "</p>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SendMessageDTO dto = new SendMessageDTO();
        dto.setTo(req.getParameter(TO_PARAMETER_NAME));
        dto.setText(req.getParameter(TEXT_PARAMETER_NAME));

        PrintWriter writer = resp.getWriter();

        try {
            this.messageService.create(SessionUtils.loadUser(req.getSession()), dto);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            writer.write("<p>Сообщение отправлено!");
        }catch (IllegalArgumentException e){
            writer.write(e.getMessage());
        }
    }
}
