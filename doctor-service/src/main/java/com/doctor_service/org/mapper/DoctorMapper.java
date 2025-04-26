package com.doctor_service.org.mapper;

import org.springframework.http.ResponseEntity;

import com.doctor_service.org.dto.DoctorRequestDTO;
import com.doctor_service.org.dto.DoctorResponseDTO;
import com.doctor_service.org.entity.Doctor;

public class DoctorMapper {
	
	public static Doctor convertToEntity(DoctorRequestDTO doctorRequestDTO) {
		return Doctor.builder()
				.doctorName(doctorRequestDTO.getName())
				.email(doctorRequestDTO.getEmail())
				.specialization(doctorRequestDTO.getSpecialization())
				.availableDays(doctorRequestDTO.getAvailableDays())
				.timings(doctorRequestDTO.getTimings())
				.build();
	}
	
	public static DoctorResponseDTO convertToDto(Doctor doctor) {
		return DoctorResponseDTO.builder()
				.id(doctor.getDoctorId().toString())
				.name(doctor.getDoctorName())
				.email(doctor.getEmail())
				.specialization(doctor.getSpecialization())
				.timings(doctor.getTimings())
				.phone(doctor.getPhone())
				.build();

	}
}
