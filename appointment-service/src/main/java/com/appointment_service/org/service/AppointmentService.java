package com.appointment_service.org.service;

import com.appointment_service.org.dto.AppointmentRequestDto;
import com.appointment_service.org.dto.AppointmentResponseDto;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {
	
	AppointmentResponseDto createAppointment(AppointmentRequestDto appointmentRequestDto);
	
	List<AppointmentResponseDto> getAppointments();
	
	AppointmentResponseDto updateAppointment(UUID id, AppointmentRequestDto appointmentRequestDto);
	
	void deleteAppointment(UUID id);
	
	AppointmentResponseDto getAppointment(UUID id);
}
