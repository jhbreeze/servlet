package com.servlet.web.servlet.servletmvc;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// controller
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String viewPath = "/WEB-INF/views/members/new-form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response); // forward : 다른 서블릿이나 JSP로 이동하는 기능(서버 내부에서 다시 호출, redirect와 다름)

	}
}
