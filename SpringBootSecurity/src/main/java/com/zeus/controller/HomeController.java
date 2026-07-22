package com.zeus.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.zeus.mapper")
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		log.info("home : 메인화면");
		return "home";
	}
	
	@RequestMapping(value = "/error/accessError", method = RequestMethod.GET)
	public String accessError() {
		log.info("accessError : 메인화면");
		return "error/accessError";
	}
	
}
