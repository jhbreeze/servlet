package com.servlet.web.springmvc.v2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.servlet.domain.member.Member;
import com.servlet.domain.member.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/springmvc/v2/members") //메서드 레벨에서 클래스 레벨로 적용
public class SpringMemberControllerV2 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@RequestMapping("/new-form")
	public ModelAndView newForm() {
		return new ModelAndView("new-form");
	}

	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		ModelAndView modelView = new ModelAndView("save-result");
		modelView.addObject("member", member);

		return modelView;
	}

	@RequestMapping
	public ModelAndView members() {
		List<Member> members = memberRepository.findAll();

		ModelAndView modelView = new ModelAndView("members");
		modelView.addObject("members", members);

		return modelView;
	}

}
