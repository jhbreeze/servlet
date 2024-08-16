package com.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream inputStream = request.getInputStream(); // HTTP 메시지 바디의 데이터를 inputStream을 사용해서 byte 코드로 꺼냄
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); //  byte 코드를 어떤 인코딩으로 바꿀건지 설정

		System.out.println("messageBody = " + messageBody);

		response.getWriter().write("ok");

	}

}
