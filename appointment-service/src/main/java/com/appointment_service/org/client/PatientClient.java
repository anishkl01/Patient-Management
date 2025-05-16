package com.appointment_service.org.client;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.appointment_service.org.dto.PatientReponseDTO;

@FeignClient(name = "PATIENT-MANAGEMENT")
public interface PatientClient {
	@GetMapping("/api/patients/{id}")
	public ResponseEntity<PatientReponseDTO> getPatientHandler(@PathVariable UUID id);
	
}
