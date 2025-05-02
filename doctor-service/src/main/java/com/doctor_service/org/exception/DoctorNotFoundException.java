package com.doctor_service.org.exception;

public class DoctorNotFoundException extends RuntimeException {
	
	public DoctorNotFoundException(String message) {
		super(message);
	}
}
