package com.patient_management.org.mapper;

import java.time.LocalDate;

import com.patient_management.org.dto.PatientReponseDTO;
import com.patient_management.org.dto.PatientRequestDTO;
import com.patient_management.org.entity.Patient;

public class PatientMapper {
	
	public static Patient convertToEntity(PatientRequestDTO patientRequestDTO) {
		return Patient.builder().name(patientRequestDTO.getName())
				.email(patientRequestDTO.getEmail())
				.address(patientRequestDTO.getAddress())
				.dateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()))
				.registeredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()))
				.phone(patientRequestDTO.getPhone())
				.gender(patientRequestDTO.getGender())
				.build();
	}
	
	public static PatientReponseDTO convertToDto(Patient patient) {
		return PatientReponseDTO.builder()
				.id(patient.getId().toString())
				.name(patient.getName())
				.email(patient.getEmail())
				.address(patient.getAddress())
				.phone(patient.getPhone())
				.gender(patient.getGender())
				.dateOfBirth(patient.getDateOfBirth().toString())
				.build();
	}
}
