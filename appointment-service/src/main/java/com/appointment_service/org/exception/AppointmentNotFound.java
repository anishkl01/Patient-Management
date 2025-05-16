package com.appointment_service.org.exception;

public class AppointmentNotFound extends RuntimeException{
	
	public AppointmentNotFound(String message) {
		super(message);
	}
}
