package com.servlet.web.frontcontroller.v5.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.servlet.web.frontcontroller.ModelView;
import com.servlet.web.frontcontroller.MyView;
import com.servlet.web.frontcontroller.v3.ControllerV3;
import com.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import com.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

	private final Map<String, Object> handlerMappingMap = new HashMap<>();
	private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

	public FrontControllerServletV5() {
		initHandlerMappingMap();
		initHandlerAdapters();
	}

	private void initHandlerMappingMap() {
		handlerMappingMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
		handlerMappingMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
		handlerMappingMap.put("/front-controller/v3/members", new MemberListControllerV3());
	}

	private void initHandlerAdapters() {
		handlerAdapters.add(new ControllerV3Adapter());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Object handler = getHandler(request);

		if(handler == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

		MyHandlerAdapter adapter = getHandlerAdapter(handler);
		ModelView modelView = adapter.handle(request, response, handlerMappingMap);

		String viewName = modelView.getViewName();
		MyView view = viewResolver(viewName);

		view.render(modelView.getModel(), request, response);
	}

	private static MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/view/*" + viewName + ".jsp");
	}

	private MyHandlerAdapter getHandlerAdapter(Object handler) {
		for (MyHandlerAdapter adapter : handlerAdapters) {
			if(adapter.supports(handler)) {
				return adapter;
			}
		}

		throw new IllegalArgumentException("no such handler: " + handler);
	}

	private Object getHandler(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return handlerMappingMap.get(requestURI);
	}

}
