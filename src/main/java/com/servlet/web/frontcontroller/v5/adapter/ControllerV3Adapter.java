package com.servlet.web.frontcontroller.v5.adapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.servlet.web.frontcontroller.ModelView;
import com.servlet.web.frontcontroller.v3.ControllerV3;
import com.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerV3Adapter implements MyHandlerAdapter {

	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV3);
	}

	@Override
	public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

		// 프론트 컨트톨러에서 필터링이 되어있기 때문에, 캐스팅해도 문제 없음.
		ControllerV3 controller = (ControllerV3)handler;

		Map<String, String> paramMap = createParamMap(request);
		ModelView view = controller.process(paramMap);

		return view;
	}


	private static Map<String, String> createParamMap(HttpServletRequest request) {

		Map<String, String> paramMap = new HashMap<>();

		request.getParameterNames().asIterator()
			.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

		return paramMap;
	}

}
