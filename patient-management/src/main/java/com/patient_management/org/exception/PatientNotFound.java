package com.patient_management.org.exception;

public class PatientNotFound extends RuntimeException {
	
	public PatientNotFound(String message) {
		super(message);
	}
}
