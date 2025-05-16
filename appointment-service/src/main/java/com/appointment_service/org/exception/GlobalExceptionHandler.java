package com.appointment_service.org.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> validateHandleException(MethodArgumentNotValidException exception) {
		Map<String, String> errors = new HashMap<>();
		
		exception.getBindingResult().getFieldErrors().forEach((error) -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		
		
		return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler(PatientDoctorNotFound.class)
	public ResponseEntity<Map<String,String>> handlePatientDoctorNotFound(PatientDoctorNotFound PatientDoctorNotFound) {
		Map<String, String> errors = new HashMap<>();
		
		errors.put("message",PatientDoctorNotFound.getMessage());
		
		return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler(AppointmentNotFound.class)
	public ResponseEntity<Map<String,String>> handleAppointmentNotFound(AppointmentNotFound AppointmentNotFound) {
		Map<String, String> errors = new HashMap<>();
		
		errors.put("message",AppointmentNotFound.getMessage());
		
		return ResponseEntity.badRequest().body(errors);
	}
	
}
