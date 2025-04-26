package com.doctor_service.org.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler()
	public ResponseEntity<Map<String, String>> validateHandleException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(),error.getDefaultMessage());
		});
		
		return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<Map<String, String>> emailAlreadyExistExceptionHandler(EmailAlreadyExistsException ex) {
		
		Map<String, String> errors = new HashMap<>();
		
		errors.put("message", "Email already exists");
		
		return ResponseEntity.badRequest().body(errors);
	}
}
