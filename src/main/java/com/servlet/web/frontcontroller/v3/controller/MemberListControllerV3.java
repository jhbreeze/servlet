package com.servlet.web.frontcontroller.v3.controller;

import java.util.List;
import java.util.Map;

import com.servlet.domain.member.Member;
import com.servlet.domain.member.MemberRepository;
import com.servlet.web.frontcontroller.v3.ControllerV3;
import com.servlet.web.frontcontroller.v3.ModelView;

public class MemberListControllerV3 implements ControllerV3 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ModelView process(Map<String, String> paramMap) {
		List<Member> members = memberRepository.findAll();

		ModelView modelView = new ModelView("members");
		modelView.getModel().put("members", members);

		return modelView;
	}
}
