package com.basicj2ee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>Hello World</h1>web.xml point towards me (HelloServlet.java) directly</body></html>");
			out.close();
		} catch(IOException ex) {
			System.err.println("error");
		}
	}
}