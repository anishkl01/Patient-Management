package com.patient_management.org.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient_management.org.dto.PatientReponseDTO;
import com.patient_management.org.dto.PatientRequestDTO;
import com.patient_management.org.dto.validators.CreatePatientValidatorGroup;
import com.patient_management.org.service.impl.PatientServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.val;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	private PatientServiceImpl patientServiceImpl;
	
	public PatientController(PatientServiceImpl patientServiceImpl) {
		this.patientServiceImpl = patientServiceImpl;
	}
	
	@PostMapping
	public ResponseEntity<PatientReponseDTO> createPatientHandler(@Validated({Default.class, CreatePatientValidatorGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO) {
		
		return ResponseEntity.ok(patientServiceImpl.createPatient(patientRequestDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<PatientReponseDTO>> getPatientsHandler() {
		return ResponseEntity.ok(patientServiceImpl.getPatients());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PatientReponseDTO> updatePatientHandler(@PathVariable UUID id, @Validated({Default.class})  @RequestBody PatientRequestDTO patientRequestDTO) {
		
		return ResponseEntity.ok(patientServiceImpl.updatePatients(id, patientRequestDTO));
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePatientHandler(@PathVariable UUID id) {
		patientServiceImpl.deletePatient(id);
		return ResponseEntity.noContent().build();
	}
}
