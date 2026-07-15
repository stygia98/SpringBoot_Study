package com.zeus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeus.domain.Member;
import com.zeus.service.MemberService;

@Slf4j
@Controller
@RequestMapping("/user")
public class MemberController {
	//http://localhost:8080/board/insertForm
	
	@Autowired
	private MemberService service;
	
	// 사용자 입력창
	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String userInsertForm(Member member, Model model) {
		model.addAttribute("member", member);
		return "user/insertForm";
	}
	
	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	public String userInsert(Member member, Model model) throws Exception {
		log.info("user/insert" + member.toString());
		boolean result = service.insert(member);
		if (result == true) { return "user/success"; }
		return "user/fail";
	}

	@RequestMapping(value = "/listForm", method = RequestMethod.GET)
	public String userList(Member member, Model model) throws Exception {
		List<Member> list = service.list();
		model.addAttribute("list", list);
		return "user/listForm";
	}
	
	@RequestMapping(value = "/selectForm", method = RequestMethod.GET)
	public String userSelect(Member member, Model model) throws Exception {
		member = service.select(member);
		model.addAttribute("member", member);
		return "user/selectForm";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String userDelete(Member member, Model model) throws Exception {
		boolean result = service.delete(member);
		if (result == false) { return "user/fail"; }
		return "user/success";
	}
	
	@RequestMapping(value = "/updateForm", method = RequestMethod.POST)
	public String userUpdateForm(Member member, Model model) throws Exception {
		member = service.select(member);
		model.addAttribute("member", member);		
		return "user/updateForm";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String userUpdate(Member member, Model model) throws Exception {
		boolean result = service.update(member);
		if (result == false) { return "user/fail"; }
		return "user/success";
	}
	

	
//	@RequestMapping(value = "/insert", method=RequestMethod.GET)
//	@ResponseBody
//	public String userInsert(Model model) throws Exception {
//		Member member = new Member();
//		member.setUserId("id1");
//		member.setUserName("zeus1");
//		member.setUserPw("pwd1");
//		
//		log.info("user/insert" + member.toString());
//		boolean result = service.insert(member);
//		if (result == true) { return "성공"; }
//		
//		return "실패";
//	}
	
//	@RequestMapping(value = "/select", method = RequestMethod.GET)
//	@ResponseBody
//	public Member userSelect(Member member, Model model) throws Exception {
//		member.setUserNo(7);
//		return service.select(member);
//	}
	
//	// 사용자 목록 요청
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	@ResponseBody
//	public List<Member> userList(Member member, Model model) throws Exception {
//		return service.list();
//	}

//	// 사용자 수정 요청
//	@RequestMapping(value = "/update", method = RequestMethod.GET)
//	@ResponseBody
//	public Boolean userUpdate(Member member, Model model) throws Exception {
//		member.setUserNo(4);
//		member.setUserName("webserver2");
//		return service.update(member);
//	}

//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	@ResponseBody
//	public Boolean userDelete(Member member, Model model) throws Exception {
//		member.setUserNo(4);
//		return service.delete(member);
//	}

//	@RequestMapping(value = "/deleteAuth", method = RequestMethod.GET)
//	@ResponseBody
//	public Boolean userDeleteAuth(Member member, Model model) throws Exception {
//		member.setUserNo(8);
//		return service.deleteAuth(member);
//	}
	
}
