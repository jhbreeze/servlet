package com.servlet.basic.response;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// status-line
		response.setStatus(HttpServletResponse.SC_OK);

		// response-headers
		response.setHeader("Content-Type", "text/plain;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 무효화
		response.setHeader("Pragma", "no-cache");
		response.setHeader("my-header", "hello");

		// header 편의 메소드
		cookie(response);
		redirect(response);

		// message body
		response.getWriter().write("ok");
	}

	private static void cookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("myCookie", "good");
		cookie.setMaxAge(600); // 600초
		response.addCookie(cookie);

	}

	private static void redirect(HttpServletResponse response) throws IOException {
		// 방법1
		response.setStatus(HttpServletResponse.SC_FOUND); // 302
		response.setHeader("Location", "/basic/hello-form.html");

		// 방법2
		response.sendRedirect("/basic/hello-form.html");
	}

}
