package com.basicj2ee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilteredServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response){
        String example = request.getParameter("example");
        request.setAttribute("example", example);
        request.setAttribute("filtered", true);
        try {
            request.getRequestDispatcher("/jsp/variable.jsp").include(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
