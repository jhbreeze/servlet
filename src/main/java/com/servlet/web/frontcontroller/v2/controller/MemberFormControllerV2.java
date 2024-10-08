package com.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;

import com.servlet.web.frontcontroller.MyView;
import com.servlet.web.frontcontroller.v2.ControllerV2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2 {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/members/new-form.jsp";
		return new MyView(viewPath);
	}

}
