package com.qsp.employee_management_system.exception;

public class NoDataAvailableException extends RuntimeException{
	
	private String message;

	public NoDataAvailableException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
}
