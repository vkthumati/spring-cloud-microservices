package com.spring.restws.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"phoneNo","emailId"})
public class UserDetails {
	private String userId;
	
	@JsonIgnore
	private String pwd;
	private String emailId;
	private String phoneNo;
	
	public UserDetails(String userId, String pwd, String emailId, String phoneNo) {
		super();
		this.userId = userId;
		this.pwd = pwd;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
}
