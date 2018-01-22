package com.example.demo.exceptions;

public class UnmatchingUserCredentialsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public UnmatchingUserCredentialsException(String message) {
		super(message);
	}
}
