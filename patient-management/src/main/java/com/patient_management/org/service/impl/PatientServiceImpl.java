package com.patient_management.org.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.patient_management.org.dto.PatientReponseDTO;
import com.patient_management.org.dto.PatientRequestDTO;
import com.patient_management.org.entity.Patient;
import com.patient_management.org.exception.EmailAlreadyExistsException;
import com.patient_management.org.exception.PatientNotFound;
import com.patient_management.org.mapper.PatientMapper;
import com.patient_management.org.repository.PatientRepository;
import com.patient_management.org.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	private PatientRepository patientRepository;
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	@Override
	public PatientReponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
		
		if(patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
			throw new EmailAlreadyExistsException("Patient with this email already exists " + patientRequestDTO.getEmail());
		}
		
		Patient patient = patientRepository.save(PatientMapper.convertToEntity(patientRequestDTO));
		
		return PatientMapper.convertToDto(patient);
	}

	@Override
	public List<PatientReponseDTO> getPatients() {
		List<Patient> patients = patientRepository.findAll();
		return patients.stream().map(PatientMapper::convertToDto).toList();
	}

	@Override
	public PatientReponseDTO updatePatients(UUID id,PatientRequestDTO patientRequestDTO) {
		
		Patient patient = patientRepository.findById(id).orElseThrow(
			() ->  new PatientNotFound("Patient not found for this Id " + id));
		boolean exists = patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id);
		System.out.println("exists "+exists);
		System.out.println("email->"+patientRequestDTO.getEmail());
		if(patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id)) {
			throw new EmailAlreadyExistsException("Patient with this email already exists " + patient.getEmail());
		}
		
		patient.setName(patientRequestDTO.getName());
	    patient.setAddress(patientRequestDTO.getAddress());
	    patient.setEmail(patientRequestDTO.getEmail());
	    patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

	    Patient updatedPatient = patientRepository.save(patient);
		
		return PatientMapper.convertToDto(updatedPatient);
		
	}

	@Override
	public void deletePatient(UUID id) {
		
		Patient patient = patientRepository.findById(id).orElseThrow(
				() ->  new PatientNotFound("Patient not found for this Id " + id));
		
		patientRepository.delete(patient);
	}

	
	


}
