package com.patient_management.org.service;

import java.util.List;
import java.util.UUID;

import com.patient_management.org.dto.PatientReponseDTO;
import com.patient_management.org.dto.PatientRequestDTO;

public interface PatientService {
	
	PatientReponseDTO createPatient(PatientRequestDTO patientRequestDTO);
	
	List<PatientReponseDTO> getPatients();
	
	PatientReponseDTO updatePatients(UUID id,PatientRequestDTO patientRequestDTO);
	
	void deletePatient(UUID id);
	
	PatientReponseDTO getPatient(UUID id);
}
