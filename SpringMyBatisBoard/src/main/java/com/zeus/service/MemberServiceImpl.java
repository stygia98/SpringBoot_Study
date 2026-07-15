package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Member;
import com.zeus.domain.MemberAuth;
import com.zeus.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

//MemberDTO <-> Member
@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	@Transactional
	public Member select(Member member) throws Exception {
		return mapper.selectMember(member);
	}
		
	@Override
	@Transactional
	public boolean insert(Member member) throws Exception {
		if (member == null || 
			member.getUserId().isEmpty() == true || 
			member.getUserPw().isEmpty() == true)
		{ return false; }
		
		log.info("MemberServiceImpl 1 = " + member.toString());
		int count1 = mapper.insertMember(member); 
		log.info("MemberServiceImpl 2 = " + member.toString());

		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_ADMIN");
		
		int count2 = mapper.insertAuth(memberAuth);
		
		return (count1 == 0 || count2 == 0) ? (false) : (true);
	}

	@Override
	@Transactional
	public boolean update(Member member) throws Exception {
		int count = mapper.updateMember(member);
//		int userNo = member.getUserNo();
		mapper.deleteAuth(member);
		List<MemberAuth> authList = member.getAuthList();
		for (MemberAuth memberAuth : authList) {
			if(memberAuth.getAuth() == null || memberAuth.getAuth().trim().length() == 0) { continue; }
			memberAuth.setUserNo(member.getUserNo());
			mapper.insertAuth(memberAuth);
		}
		return (count == 0) ? (false) : (true);
	}

	@Override
	@Transactional
	public boolean delete(Member member) throws Exception {
		int count = mapper.deleteMember(member);
		return (count == 0) ? (false) : (true);
	}

	@Override
	@Transactional
	public boolean deleteAuth(Member member) throws Exception {
		int count = mapper.deleteAuth(member);
		return (count == 0) ? (false) : (true);
	}
	
	@Override
	@Transactional
	public List<Member> list() throws Exception {
		return mapper.list();	
	}
	
}
