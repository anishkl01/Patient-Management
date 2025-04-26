package com.doctor_service.org.exception;

public class EmailAlreadyExistsException extends RuntimeException {
	
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
