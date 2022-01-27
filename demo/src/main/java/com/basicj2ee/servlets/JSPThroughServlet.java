package com.basicj2ee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSPThroughServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("/jsp/helloServlet.jsp").include(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
