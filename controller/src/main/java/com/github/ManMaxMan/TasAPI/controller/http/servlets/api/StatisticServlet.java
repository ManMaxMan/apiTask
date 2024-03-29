package com.github.ManMaxMan.TasAPI.controller.http.servlets.api;

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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/api/admin/statistics")
public class StatisticServlet extends HttpServlet {

    private final IStatisticService statisticService= ServiceFactory.getStatisticService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        StatisticDTO statisticDTO = statisticService.get();
        writer.write("<p>"+statisticDTO+"</p>");

    }
}
