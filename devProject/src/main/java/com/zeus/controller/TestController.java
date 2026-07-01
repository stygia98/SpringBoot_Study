package com.zeus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.dto.Address;
import com.zeus.dto.BoardDTO;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	// http://192.168.0.98:8080/home
	// http://127.0.0.1:8080/home
	// http://localhost:8080/home
	// get put delete post patch

	@GetMapping("/test/posthome")
	public void posthome() {}
	
	@GetMapping("/test/ajaxHome4")
	public void posthome1() {}
	
	@PostMapping(value = "/test/gohome4", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> gohome4(MultipartFile file) {
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		log.info("/test/gohome toString(): " + file.getOriginalFilename());
		log.info("/test/gohome toString(): " + file.getSize());
		log.info("/test/gohome toString(): " + file.getContentType());
		return entity;
	}

//	@RequestMapping(value = "/test/gohome2", method = RequestMethod.POST)
//	public ResponseEntity<String> gohome2(Model model, @RequestBody ArrayList<BoardDTO> bdList) {
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		
//		for (BoardDTO bd : bdList) {
//			log.info("/test/gohome1 toString(): " + bd.getBoardNo());
//			log.info("/test/gohome1 toString(): " + bd.getTitle());			
//		}
//		return entity;
//	}
	
//	@RequestMapping(value = "/test/gohome1/{boardNo}", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<String> gohome2(Model model, @PathVariable("boardNo") String boardNo, @RequestBody BoardDTO bd) {
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		
//		log.info("/test/gohome1 boardNo() : " + boardNo);
//		log.info("/test/gohome1 toString(): " + bd.toString());
//
//		return entity;
//	}
	
//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.POST)
//	@ResponseBody
//	public String gohome1(Model model, BoardDTO bd) {
//		ArrayList<MultipartFile> plist = bd.getPicture();
//		for (MultipartFile p : plist) {
//			log.info("/test/gohome1 toString(): " + p.getOriginalFilename());
//			log.info("/test/gohome1 toString(): " + p.getSize());
//			log.info("/test/gohome1 toString(): " + p.getContentType());
//		}
//		return null;
//	}
	
//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.POST)
//	@ResponseBody
//	public String gohome1(Model model, MultipartFile picture) {
//		log.info("/test/gohome1 toString(): " + picture.getOriginalFilename());
//		log.info("/test/gohome1 toString(): " + picture.getSize());
//		log.info("/test/gohome1 toString(): " + picture.getContentType());
//		
//		return null;
//	}
	
//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.GET)
//	@ResponseBody
//	public ArrayList<Address> gohomeGet2(Model model, @ModelAttribute BoardDTO bdo) {
//		ArrayList<Address> add = bdo.getAddress();
//		log.info("/test/gohome1 toString(): " + add.toString());
//		return add;
//	}

//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.POST)
//	public String gohomePost(@ModelAttribute BoardDTO bd) {
//		if(bd.getHobby() != null) {
//			log.info("/test/gohome1 toString(): " + bd.getHobby().size());
//		}
//		log.info("/test/gohome1 toString(): " + bd.toString());
//		return "test/gohome1";
//	}
	
//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.GET)
//	public String gohomeGet1(@ModelAttribute Address address) {
//		log.info("/test/gohome1 toString(): " + address.toString());
//		return "test/gohome1";
//	}
	
//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.POST)
//	public String gohome(Model model, @RequestParam String nationality) {
//		log.info("/test/gohome1 toString(): " + nationality);
//		
//		return "test/gohome1";
//	}
	
//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.GET)
//	public String gohome(Model model, @DateTimeFormat(pattern = "yyyyMMdd") Date dateofBirth) {
//		log.info("/test/gohome1 toString(): " + dateofBirth.toString());
//		
//		return "test/gohome1";
//	}
		
//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.GET)
//	public String gohome(Model model, @ModelAttribute BoardDTO bd) {
//		log.info("/test/gohome1 toString(): " + bd.toString());
//		
//		return "test/gohome1";
//	}
	
//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.GET)
//	public String gohome(Model model, @RequestParam Date dateofBirth) {
//		log.info("/test/gohome1 toString(): " + dateofBirth.toString());
//		
//		return "test/gohome1";
//	}
	
//	@RequestMapping(value = "/test/gohome1", method = RequestMethod.POST)
//	public String gohome(Model model, @ModelAttribute BoardDTO boardDTO) {
//		log.info("/test/gohome1 toString(): " + boardDTO.toString());
//		
//		return "test/gohome1";
//	}

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
