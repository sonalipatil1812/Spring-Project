package com.techno.ems.exception;

public class EmployeeException extends RuntimeException {
	private String msg;

	public EmployeeException(String msg) {
		super(msg);

	}
}