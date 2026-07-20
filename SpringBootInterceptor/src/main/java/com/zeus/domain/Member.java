package com.zeus.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private Date regDate;
	private Date updDate;
}