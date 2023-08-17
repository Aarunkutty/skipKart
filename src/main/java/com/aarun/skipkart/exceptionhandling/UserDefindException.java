package com.aarun.skipkart.exceptionhandling;

public class UserDefindException extends RuntimeException {

	private String message;
	
	public UserDefindException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
