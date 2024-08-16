package com.servlet.basic.request;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 전체 파라미터 조회
		System.out.println("전체 파라미터 조회");
		request.getParameterNames().asIterator()
			.forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));

		// 단일 파라미터 조회
		String userName = request.getParameter("userName");
		System.out.println("userName = " + userName);

		// 이름이 동일한 파라미터 조회
		String[] userNames = request.getParameterValues("userName");
		for (String name : userNames) {
			System.out.println("userName = " + name);
		}

		response.getWriter().write("ok");
	}

}
