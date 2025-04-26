package com.doctor_service.org.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor_service.org.dto.DoctorRequestDTO;
import com.doctor_service.org.dto.DoctorResponseDTO;
import com.doctor_service.org.service.impl.DoctorServiceImpl;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	
	private DoctorServiceImpl doctorServiceImpl;
	
	public DoctorController(DoctorServiceImpl doctorServiceImpl) {
		this.doctorServiceImpl = doctorServiceImpl;
	}
	
	@GetMapping
	public String getDoctorsHandler() {
		return "good server";
	}
	
	@PostMapping
	public ResponseEntity<DoctorResponseDTO> createDoctorHandler(@RequestBody DoctorRequestDTO doctorRequestDTO) {
	
		return ResponseEntity.ok(doctorServiceImpl.createDoctor(doctorRequestDTO));
	}
}
