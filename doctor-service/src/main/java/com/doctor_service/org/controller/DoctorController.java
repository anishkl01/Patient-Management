package com.doctor_service.org.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import com.doctor_service.org.dto.DoctorRequestDTO;
import com.doctor_service.org.dto.DoctorResponseDTO;
import com.doctor_service.org.service.impl.DoctorServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

	private DoctorServiceImpl doctorServiceImpl;

	public DoctorController(DoctorServiceImpl doctorServiceImpl) {
		this.doctorServiceImpl = doctorServiceImpl;
	}

	@GetMapping
	public ResponseEntity<List<DoctorResponseDTO>> getDoctorsHandler() {
		return ResponseEntity.ok(doctorServiceImpl.getDoctors());
	}

	@PostMapping
	public ResponseEntity<DoctorResponseDTO> createDoctorHandler(
			@Valid @RequestBody DoctorRequestDTO doctorRequestDTO) {
		return ResponseEntity.ok(doctorServiceImpl.createDoctor(doctorRequestDTO));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DoctorResponseDTO> getDoctor(@PathVariable UUID id) {
		return ResponseEntity.ok(doctorServiceImpl.getDoctor(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable UUID id) {

		doctorServiceImpl.deleteDoctor(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")	
	public ResponseEntity<DoctorResponseDTO> updateDoctorHandler(@PathVariable UUID id,
			@Valid @RequestBody DoctorRequestDTO doctorRequestDTO) {
		return ResponseEntity.ok(doctorServiceImpl.updateDoctor(id, doctorRequestDTO));
	}
}
