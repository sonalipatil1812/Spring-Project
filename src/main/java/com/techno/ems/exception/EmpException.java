package com.techno.ems.exception;

public class EmpException extends RuntimeException {
	private String msg;

	public EmpException(String msg) {
		super(msg);

	}
}
