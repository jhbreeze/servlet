package com.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet.service");
		System.out.println("request = " + request);
		System.out.println("response = " + response);

		String userName = request.getParameter("userName");
		System.out.println("userName = " + userName);

		response.setContentType("text/plain"); // setting header
		response.setCharacterEncoding("utf-8"); // setting header
		response.getWriter().write("hello " + userName); // setting body
	}

}
