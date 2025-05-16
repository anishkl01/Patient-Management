package com.appointment_service.org.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.appointment_service.org.dto.DoctorResponseDTO;



@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorClient {
	
	@GetMapping("/api/doctors/{id}")
	public ResponseEntity<DoctorResponseDTO> getDoctor(@PathVariable UUID id);
}
