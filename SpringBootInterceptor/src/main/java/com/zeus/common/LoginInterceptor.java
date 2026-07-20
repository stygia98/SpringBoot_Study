package com.zeus.common;

import java.lang.reflect.Method;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//경로
		log.info("login ~~ preHandle() request = " + request.getRequestURI()); // 경로
		HandlerMethod method = (HandlerMethod)handler;
		Method methodObj = method.getMethod();
		log.info("login ~~ preHandle() bean = " + method.getBean()); // 객체 주소
		log.info("login ~~ preHandle() method = " + methodObj); // 함수
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfo") != null) {
			session.removeAttribute("userInfo");
		}
		// login ~~ preHandle() request = /login/insert
		// login ~~ preHandle() bean = com.zeus.controller.LoginController@6ae274ed
		// login ~~ preHandle() method = public java.lang.String com.zeus.controller.LoginController.loginInsert(com.zeus.domain.Member,org.springframework.ui.Model)
		// return HandlerInterceptor.super.preHandle(request, response, handler);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		log.info("login ~~ postHandle() request = " + request.getRequestURI()); // 경로
		HandlerMethod method = (HandlerMethod)handler;
		Method methodObj = method.getMethod();
		log.info("login ~~ postHandle() bean = " + method.getBean()); // 객체 주소
		log.info("login ~~ postHandle() method = " + methodObj); // 함수
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		
		Object member = modelMap.get("member");
		
		if(member != null) {
			log.info("login ~~ postHandle() member = " + member); // 함수
			session.setAttribute("userInfo", member);
			response.sendRedirect("/home");
		}
		// login ~~ postHandle() request = /login/insert
		// login ~~ postHandle() bean = com.zeus.controller.LoginController@6ae274ed
		// login ~~ postHandle() method = public java.lang.String com.zeus.controller.LoginController.loginInsert(com.zeus.domain.Member,org.springframework.ui.Model)
		// login ~~ postHandle() member = Member(userNo=0, userId=hgd, userPw=123456, userName=null, regDate=null, updDate=null, authList=null)
		// HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		log.info("login ~~ afterCompletion() request = " + request.getRequestURI()); // 경로
		HandlerMethod method = (HandlerMethod)handler;
		Method methodObj = method.getMethod();
		log.info("login ~~ afterCompletion() bean = " + method.getBean()); // 객체 주소
		log.info("login ~~ afterCompletion() method = " + methodObj); // 함수

		// login ~~ afterCompletion() request = /login/insert
		// login ~~ afterCompletion() bean = com.zeus.controller.LoginController@132b5d8f
		// login ~~ afterCompletion() method = public java.lang.String com.zeus.controller.LoginController.loginInsert(com.zeus.domain.Member,org.springframework.ui.Model)
		// HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
