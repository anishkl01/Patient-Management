package com.doctor_service.org.service;

import java.util.List;
import java.util.UUID;

import com.doctor_service.org.dto.DoctorRequestDTO;
import com.doctor_service.org.dto.DoctorResponseDTO;

public interface DoctorService {
	
	DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO);
	
	List<DoctorResponseDTO> getDoctors();
	
	DoctorResponseDTO getDoctor(UUID id);
	
	void deleteDoctor(UUID id);
	
	DoctorResponseDTO updateDoctor(UUID id, DoctorRequestDTO doctorRequestDTO);
	
}
