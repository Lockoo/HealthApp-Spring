package com.example.demo.helpers;

import com.example.demo.domain.User;

public class ExecutionStatus {
	private String code;
	private String message;
	private User_Json user;
	
	public ExecutionStatus(){
		
	}
	
	public ExecutionStatus(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ExecutionStatus(String code, String message, User_Json user) {
		this.code = code;
		this.message = message;
		this.user = user;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public User_Json getUser() {
		return user;
	}

	public void setUser(User_Json user) {
		this.user = user;
	}
}
