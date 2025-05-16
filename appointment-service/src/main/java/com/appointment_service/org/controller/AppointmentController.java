package com.appointment_service.org.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment_service.org.dto.AppointmentResponseDto;
import com.appointment_service.org.service.impl.AppointmentServiceImpl;
import com.appointment_service.org.dto.AppointmentRequestDto;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	private final AppointmentServiceImpl appointmentServiceImpl;

	private static final Logger log = LoggerFactory.getLogger(AppointmentController.class);

	public AppointmentController(AppointmentServiceImpl appointmentServiceImpl) {
		this.appointmentServiceImpl = appointmentServiceImpl;
	}

	@PostMapping
	public ResponseEntity<AppointmentResponseDto> createAppointmentHandler(
			@Valid @RequestBody AppointmentRequestDto appointmentRequestDto) {
		return ResponseEntity.ok(appointmentServiceImpl.createAppointment(appointmentRequestDto));
	}

	@GetMapping
	public ResponseEntity<List<AppointmentResponseDto>> getAppointmentsHandler() {
		return ResponseEntity.ok(appointmentServiceImpl.getAppointments());
	}

	@PutMapping("/{id}")
	public ResponseEntity<AppointmentResponseDto> updateAppointmentHandler(@PathVariable UUID id,
			@Valid @RequestBody AppointmentRequestDto appointmentRequestDto) {
		return ResponseEntity.ok(appointmentServiceImpl.updateAppointment(id, appointmentRequestDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> updateAppointmentHandler(@PathVariable UUID id) {

		appointmentServiceImpl.deleteAppointment(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<AppointmentResponseDto> getAppointmentHandler(@PathVariable UUID id) {
		return ResponseEntity.ok(appointmentServiceImpl.getAppointment(id));
	}

}
