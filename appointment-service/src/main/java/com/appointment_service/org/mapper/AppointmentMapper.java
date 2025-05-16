package com.appointment_service.org.mapper;

import com.appointment_service.org.dto.AppointmentRequestDto;
import com.appointment_service.org.dto.AppointmentResponseDto;
import com.appointment_service.org.entity.Appointment;

public class AppointmentMapper {
	
	public static Appointment convertToEntity(AppointmentRequestDto requestDto) {
		return Appointment.builder()
				.patientId(requestDto.getPatientId())
				.doctorId(requestDto.getDoctorId())
				.aptTime(requestDto.getAptTime())
				.aptDate(requestDto.getAptDate())
				.reason(requestDto.getReason())
				.status(requestDto.getStatus())
				.build();
	}
	
	public static AppointmentResponseDto convertToDto(Appointment appointment) {
		return AppointmentResponseDto.builder()
				.aptId(appointment.getAptId().toString())
				.doctorId(appointment.getDoctorId().toString())
				.patientId(appointment.getDoctorId().toString())
				.aptTime(appointment.getAptTime().toString())
				.aptDate(appointment.getAptDate().toString())
				.reason(appointment.getReason().toString())
				.status(appointment.getStatus().toString())
				.build();
				
	}
}
