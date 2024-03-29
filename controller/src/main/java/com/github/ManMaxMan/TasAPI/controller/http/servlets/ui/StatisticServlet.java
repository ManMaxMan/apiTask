package com.github.ManMaxMan.TasAPI.controller.http.servlets.ui;


import com.github.ManMaxMan.TasAPI.controller.http.utils.SessionUtils;
import com.github.ManMaxMan.TasAPI.core.dto.StatisticDTO;
import com.github.ManMaxMan.TasAPI.service.api.IStatisticService;
import com.github.ManMaxMan.TasAPI.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/ui/admin/statistics")
public class StatisticServlet extends HttpServlet {

    private final IStatisticService statisticService= ServiceFactory.getStatisticService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StatisticDTO statisticDTO=statisticService.get();
        req.setAttribute("statistics",statisticDTO);
        req.getRequestDispatcher("/ui/admin/stat.jsp").forward(req,resp);
    }
}
