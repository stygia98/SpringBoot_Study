package com.zeus.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.dto.Member;

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
	
	@GetMapping(value = "/home1")
	public String home1(Model model) {
		// Handling business logic - 값을 처리하여 home.jsp로 보냄
		log.info("사용자가 home1에 접속");
		model.addAttribute("serverTime", new Date().toString());
		return "home1";
	}
	
	@GetMapping(value = "/home2")
	public String home2(Model model) {
		// Handling business logic - 값을 처리하여 home.jsp로 보냄
		log.info("사용자가 home2에 접속");
		
		Member member = new Member();
		member.setEmail("kdj@naver.com");
		member.setPassword("1234");
		member.setUserId("userID");
		member.setUserName("zeus");
		LocalDate ld = LocalDate.of(2026, 6, 25);
		member.setDateOfBirth(ld);
				
		model.addAttribute("serverTime", new Date().toString());
		model.addAttribute(member);
		
		return "home2";
	}
	
	@GetMapping(value = "/home3")
	public String home3(Model model) {
		// Handling business logic - 값을 처리하여 home.jsp로 보냄
		log.info("사용자가 home3에 접속");
				
		model.addAttribute("serverTime", new Date().toString());
		
		return "home3";
	}
	
	@GetMapping(value = "/home4")
	public String home4(Model model) {
		// Handling business logic - 값을 처리하여 home.jsp로 보냄
		log.info("사용자가 home4에 접속");
		
		String[] hobbyArray = new String[] {"자바스크립트", "자바", "스프링", "파이썬"};
		
		List<String> list = new ArrayList<String>();
		list.add("자바스크립트");
		list.add("자바"); list.add("스프링"); list.add("파이썬");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("data1", "자바스크립트");
		map.put("data2", "자바");
		map.put("data3", "스프링");
		map.put("data4", "파이썬");
		
		String hobbyString = "Java,Python,Spring";
		
		
		model.addAttribute("hobbyString", hobbyString);
		model.addAttribute("hobbyArray", hobbyArray);
		model.addAttribute("list", list);
		model.addAttribute("map", map);

		model.addAttribute("serverTime", new Date().toString());
		
		return "home4";
	}

	@GetMapping(value = "/list")
	public void home5(Model model) {
		// Handling business logic - 값을 처리하여 home.jsp로 보냄
		log.info("사용자가 home5에 접속");

		model.addAttribute("serverTime", new Date().toString());
	}
	
	@GetMapping(value = "/home1101")
	public String home1101(Model model) {
		// Handling business logic - 값을 처리하여 home.jsp로 보냄
		log.info("사용자가 home1101에 접속");

		model.addAttribute("serverTime", new Date().toString());
		return "home1101";
	}
	
}
