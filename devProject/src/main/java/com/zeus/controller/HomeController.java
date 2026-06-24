package com.zeus.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	// http://192.168.0.98:8080/home
	// http://127.0.0.1:8080/home
	// get put delete post patch
	
	@RequestMapping(value = "/home")
	public String home() {
		// Handling business logic - 값을 처리하여 home.jsp로 보냄
		Date date = new Date();
//		String.format("접속시간 : %s \n", date.toString());
		log.info(String.format("접속시간 : %s", date.toString()));
		return "home";
	}
	
	@RequestMapping(value = "/web")
	public String web() {
		// Handling business logic - 값을 처리하여 home.jsp로 보냄
		return "web";
	}
	
}
