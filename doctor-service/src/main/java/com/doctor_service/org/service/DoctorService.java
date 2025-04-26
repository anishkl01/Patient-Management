package com.doctor_service.org.service;

import com.doctor_service.org.dto.DoctorRequestDTO;
import com.doctor_service.org.dto.DoctorResponseDTO;

public interface DoctorService {
	
	DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO);
	
	
}
