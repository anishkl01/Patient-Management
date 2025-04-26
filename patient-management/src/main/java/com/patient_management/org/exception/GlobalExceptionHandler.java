package com.patient_management.org.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler()
	public ResponseEntity<Map<String, String>> handleValidateException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(),error.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<Map<String, String>> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
		
		log.warn("Email already exist {}",ex.getMessage());
		
		Map<String, String> errors = new HashMap<>();
		
		errors.put("message", "Email already exist");
		
		return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler(PatientNotFound.class)
	public ResponseEntity<Map<String, String>> handlePatientNotFound(PatientNotFound ex) {
		
		log.warn("Patient not found {} ",ex.getMessage());
		
		Map<String, String> errors = new HashMap<>();
		
		errors.put("message", ex.getMessage());
		
		return ResponseEntity.badRequest().body(errors);
	}
}
