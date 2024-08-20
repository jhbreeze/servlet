package com.servlet.web.servlet;

import java.io.IOException;

import com.servlet.basic.HelloServlet;
import com.servlet.domain.member.Member;
import com.servlet.domain.member.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "memberServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HelloServlet {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		response.setContentType("text/html;charset=utf-8");

	}
}
