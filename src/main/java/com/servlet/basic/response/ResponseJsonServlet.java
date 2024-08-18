package com.servlet.basic.response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servlet.basic.HelloData;
import com.servlet.basic.HelloServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HelloServlet {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		HelloData helloData = new HelloData();
		helloData.setUsername("hello");
		helloData.setAge(20);

		String result = objectMapper.writeValueAsString(helloData); // 객체를 JSON 문자로 변경

		response.getWriter().write(result);

	}
}