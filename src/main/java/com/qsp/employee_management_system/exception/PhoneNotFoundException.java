package com.qsp.employee_management_system.exception;

public class PhoneNotFoundException extends RuntimeException{
	
	private String message;

	public PhoneNotFoundException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
}
