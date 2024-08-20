package com.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.basic.HelloServlet;
import com.servlet.domain.member.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HelloServlet {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		PrintWriter writer = response.getWriter();



	}
}
