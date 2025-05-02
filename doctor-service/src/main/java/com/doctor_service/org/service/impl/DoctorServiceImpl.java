package com.doctor_service.org.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.doctor_service.org.dto.DoctorRequestDTO;
import com.doctor_service.org.dto.DoctorResponseDTO;
import com.doctor_service.org.entity.Doctor;
import com.doctor_service.org.exception.DoctorNotFoundException;
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
					"Doctor with this email already exists: " + doctorRequestDTO.getEmail());
		}

		Doctor doctor = DoctorMapper.convertToEntity(doctorRequestDTO);

		Doctor savedDoctor = doctorRepository.save(doctor);

		return DoctorMapper.convertToDto(savedDoctor);
	}

	@Override
	public List<DoctorResponseDTO> getDoctors() {
		List<DoctorResponseDTO> doctors = doctorRepository.findAll().stream().map(DoctorMapper::convertToDto)
				.collect(Collectors.toList());

		return doctors;
	}

	@Override
	public DoctorResponseDTO getDoctor(UUID id) {
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor not found for id: " + id.toString()));

		return DoctorMapper.convertToDto(doctor);
	}

	@Override
	public void deleteDoctor(UUID id) {
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor not found for id: " + id.toString()));
		
		doctorRepository.delete(doctor);
		
	}

	@Override
	public DoctorResponseDTO updateDoctor(UUID id, DoctorRequestDTO doctorRequestDTO) {
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor not found for id: " + id.toString()));
		
		doctor.setDoctorName(doctorRequestDTO.getName());
		doctor.setEmail(doctorRequestDTO.getEmail());
		doctor.setPhone(doctorRequestDTO.getPhone());
		doctor.setSpecialization(doctorRequestDTO.getSpecialization());
		doctor.setTimings(doctorRequestDTO.getTimings());
		doctor.setAvailableDays(doctorRequestDTO.getAvailableDays());
		
		Doctor updatedDoctor =  doctorRepository.save(doctor);
		
		return DoctorMapper.convertToDto(updatedDoctor);
	}

}
