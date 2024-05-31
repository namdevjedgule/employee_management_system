package com.qsp.employee_management_system.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private int status;
	private String message;
	private T data;
}
