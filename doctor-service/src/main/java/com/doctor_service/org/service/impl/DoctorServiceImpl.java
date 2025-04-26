package com.doctor_service.org.service.impl;

import org.springframework.stereotype.Service;

import com.doctor_service.org.dto.DoctorRequestDTO;
import com.doctor_service.org.dto.DoctorResponseDTO;
import com.doctor_service.org.entity.Doctor;
import com.doctor_service.org.exception.EmailAlreadyExistsException;
import com.doctor_service.org.mapper.DoctorMapper;
import com.doctor_service.org.repository.DoctorRepository;
import com.doctor_service.org.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	private DoctorRepository doctorRepository;

	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	@Override
	public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {

		if (doctorRepository.existsByEmail(doctorRequestDTO.getEmail())) {
			throw new EmailAlreadyExistsException(
					"Doctor with this email already exists" + doctorRequestDTO.getEmail());
		}
		
		Doctor doctor = DoctorMapper.convertToEntity(doctorRequestDTO);
		
		Doctor savedDoctor = doctorRepository.save(doctor);
		
		return DoctorMapper.convertToDto(savedDoctor);
	}

}
