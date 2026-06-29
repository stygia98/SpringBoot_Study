package com.zeus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeus.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	// http://192.168.0.98:8080/home
	// http://127.0.0.1:8080/home
	// http://localhost:8080/home
	// get put delete post patch

	
	
	@GetMapping("/test/posthome")
	public void posthome() {
		log.info("/test/posthome");
	}
	
	@RequestMapping(value = "/test/gohome1", method = RequestMethod.POST)
	public String gohome(Model model, @ModelAttribute BoardDTO boardDTO) {
		log.info("/test/gohome1 toString(): " + boardDTO.toString());
		
		return "test/gohome1";
	}

//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.POST)
//	public String gohome(Model model, @RequestParam("userId") String userId) {
//		log.info("/test/gohome1 userName: " + userId);
//		
//		return "test/gohome1";
//	}
	
//	http://localhost:8080/test/gohome1/id/coin100
//	@RequestMapping(value = "/test/gohome1/{userid}/{coin}", method = RequestMethod.GET)
//	public String gohome(Model model, @PathVariable("userid") String userId, @PathVariable("coin") String coin) {
//		log.info("/test/gohome1 userid: " + userId);
//		log.info("/test/gohome1 coin: " + coin);
//		
//		return "test/gohome1";
//	}

//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.POST)
//	public String gohome(Model model, String userId, String password, int coin) {
//		log.info("/test/gohome1 userid: " + userId);
//		log.info("/test/gohome1 password: " + password);
//		log.info("/test/gohome1 coin: " + (coin+1111) );
//		
//		return "test/gohome1";
//	}

//	http://localhost:8080/test/gohome1?userid=kdj&password=1234
//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.GET)
//	public void gohome(Model model, String userid, String password) {
//		log.info("/test/gohome1 userid: " + userid);
//		log.info("/test/gohome1 password: " + password);
//	}
	
//	http://localhost:8080/test/gohome1/100
//	@RequestMapping(value = "/test/gohome1/{userid}", method = RequestMethod.GET)
//	public String gohome(Model model, @PathVariable("userid") String userid) {
//		log.info("/test/gohome1 userid: " + userid);
//		
//		return "test/gohome1";
//	}
	
}
