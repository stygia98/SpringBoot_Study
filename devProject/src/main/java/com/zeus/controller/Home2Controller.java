package com.zeus.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Slf4j
@Controller
public class Home2Controller {

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value = "/home/mainpage", method=RequestMethod.GET)
	public String home(Model model) {
		log.info("/home/mainpage");
		
		String[] args = {"lee"};
		
		String message = messageSource.getMessage("welcome.message", args, Locale.KOREAN); 
		String message2 = messageSource.getMessage("welcome.message", args,Locale.ENGLISH); 
		log.info("Welcome message : " + message); 
		log.info("Welcome message2 : " + message2); 
		
		return "home/mainpage";
	}
}
