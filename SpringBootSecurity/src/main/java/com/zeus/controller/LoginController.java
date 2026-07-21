package com.zeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class LoginController {
	@RequestMapping(value = "/login/insertForm", method = RequestMethod.GET)
	public String insertForm() {
		log.info("insertForm : 모두가 접근 가능");
		return "login/insertForm";
	}

	@RequestMapping("/logout/logoutForm")
	public String logoutForm() {
		log.info("logoutForm");
		return "login/logoutForm";
	}
	
}
