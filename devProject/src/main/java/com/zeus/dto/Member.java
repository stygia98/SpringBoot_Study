package com.zeus.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Member {
	@NotBlank // userId != null, len(trim(userId))>0
	private String userId;
	private String password;
	
	@NotBlank
	@Size(max=3)
	private String userName;
	
	@Email
	private String email;
	private String introduction;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	private boolean foreigner;
	private String[] hobbyArray;
	private List<String> hobbyList1;
	private List<String> hobbyList2;
	private List<String> hobbyValue;
	private Map<String, String>hobbyMap;
//	private List<CodeLabelValue> hobbyList;
}
