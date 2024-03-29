package com.github.ManMaxMan.TasAPI.controller.http.filter;

import com.github.ManMaxMan.TasAPI.controller.http.utils.SessionUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*","/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse) response;

        String contextPath=req.getContextPath();
        HttpSession session=req.getSession();

        if (SessionUtils.isAdmin(session)){
            chain.doFilter(req,resp);
        } else{
            resp.sendRedirect(contextPath+"/");
        }
    }

}
