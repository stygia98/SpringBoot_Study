package com.zeus.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.domain.Board;
import com.zeus.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/board")
public class RestBoardController {
	// http://192.168.0.98:8080/home
	// http://127.0.0.1:8080/home
	// get put delete post patch
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello() {
		return "안녕하세요";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody BoardDTO list() {
		BoardDTO bdto = new BoardDTO();
		bdto.setBoardNo(10);
		bdto.setContent("컨텐츠");
		bdto.setTitle("타이틀");
		bdto.setWriter("작성자");
		
		return bdto;
	}
	
	@RequestMapping(value = "/listarray", method = RequestMethod.GET)
	public @ResponseBody List<BoardDTO> listarray() {
		List<BoardDTO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			BoardDTO bdto = new BoardDTO();
			bdto.setBoardNo(i);
			bdto.setContent("컨텐츠" + i);
			bdto.setTitle("타이틀" + i);
			bdto.setWriter("작성자" + i);
			list.add(bdto);
		}
		return list;
	}
	
}
