package com.github.ManMaxMan.TasAPI.controller.http.servlets.ui;


import com.github.ManMaxMan.TasAPI.controller.http.utils.SessionUtils;
import com.github.ManMaxMan.TasAPI.core.dto.MessageDTO;
import com.github.ManMaxMan.TasAPI.core.dto.UserDTO;
import com.github.ManMaxMan.TasAPI.service.api.IMessageService;
import com.github.ManMaxMan.TasAPI.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ui/user/chats")
public class ChatsServlet extends HttpServlet {

    private final IMessageService messageService= ServiceFactory.getMessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDTO user= SessionUtils.loadUser(req.getSession());

        if (user==null){
            req.getRequestDispatcher("/ui/user/index.jsp").forward(req,resp);
            return;
        }

        List<MessageDTO> messages=messageService.list(user);

        req.setAttribute("messages",messages);

        req.getRequestDispatcher("/ui/user/chats.jsp").forward(req,resp);
    }
}
