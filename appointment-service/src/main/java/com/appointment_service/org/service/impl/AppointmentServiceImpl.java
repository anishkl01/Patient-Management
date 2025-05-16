package com.appointment_service.org.service.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.appointment_service.org.client.DoctorClient;
import com.appointment_service.org.client.PatientClient;
import com.appointment_service.org.dto.AppointmentRequestDto;
import com.appointment_service.org.dto.AppointmentResponseDto;
import com.appointment_service.org.dto.DoctorResponseDTO;
import com.appointment_service.org.dto.PatientReponseDTO;
import com.appointment_service.org.entity.Appointment;
import com.appointment_service.org.exception.AppointmentNotFound;
import com.appointment_service.org.exception.PatientDoctorNotFound;
import com.appointment_service.org.mapper.AppointmentMapper;
import com.appointment_service.org.repository.AppointmentRepository;
import com.appointment_service.org.service.AppointmentService;

import feign.FeignException;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	
	private final DoctorClient docClient;
	
	private final PatientClient patientClient;
	
	private final AppointmentRepository appointmentRepository;
	
	private static final Logger log = LoggerFactory.getLogger(AppointmentServiceImpl.class);
	
	public AppointmentServiceImpl(DoctorClient doctorClient, PatientClient patientClient, AppointmentRepository appointmentRepository) {
		this.docClient = doctorClient;
		this.patientClient = patientClient;
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public AppointmentResponseDto createAppointment(AppointmentRequestDto appointmentRequestDto) {
		try {
			ResponseEntity<PatientReponseDTO>  patient = patientClient.getPatientHandler(appointmentRequestDto.getPatientId());
			ResponseEntity<DoctorResponseDTO>  doctor = docClient.getDoctor(appointmentRequestDto.getDoctorId());
			
			
			if(!patient.getStatusCode().is2xxSuccessful() || !doctor.getStatusCode().is2xxSuccessful()) {
				throw new PatientDoctorNotFound("Patient or Doctor not found");
			}
			
			Appointment appointment =  AppointmentMapper.convertToEntity(appointmentRequestDto);
			
			Appointment savedAppointment = appointmentRepository.save(appointment);
			
			return AppointmentMapper.convertToDto(savedAppointment);
			
		} catch (FeignException fe) {
		    throw new PatientDoctorNotFound("External service error: " + fe.getMessage());
		} catch (Exception ex) {
			throw new PatientDoctorNotFound("Internal error: " + ex.getMessage());
		}
	
	}

	@Override
	public List<AppointmentResponseDto> getAppointments() {
		List<Appointment> appointments =  appointmentRepository.findAll();
		
		List<AppointmentResponseDto> appointmentDto = appointments.stream()
		.map(AppointmentMapper::convertToDto).toList();
		
		return appointmentDto;
		
	}

	@Override
	public AppointmentResponseDto updateAppointment(UUID id, AppointmentRequestDto appointmentRequestDto) {
		
		Appointment appointment = appointmentRepository.findById(id).orElseThrow( () ->
			 new AppointmentNotFound("Appointment not found for this id: " + id )
		);
		
		appointment.setDoctorId(appointmentRequestDto.getDoctorId());
		appointment.setPatientId(appointmentRequestDto.getPatientId());
		appointment.setAptTime(appointmentRequestDto.getAptTime());
		appointment.setAptDate(appointmentRequestDto.getAptDate());
		appointment.setReason(appointmentRequestDto.getReason());
		appointment.setStatus(appointmentRequestDto.getStatus());
		
		
		Appointment updatedAppointment = appointmentRepository.save(appointment);
		
		return AppointmentMapper.convertToDto(updatedAppointment);
		
	}

	@Override
	public void deleteAppointment(UUID id) {
		Appointment appointment = appointmentRepository.findById(id).orElseThrow( () ->
		 new AppointmentNotFound("Appointment not found for this id: " + id )
		);
		
		appointmentRepository.delete(appointment);
	}
	
	public AppointmentResponseDto getAppointment(UUID id) {
		Appointment appointment = appointmentRepository.findById(id).orElseThrow( () ->
		 new AppointmentNotFound("Appointment not found for this id: " + id )
		);
		
		return AppointmentMapper.convertToDto(appointment);
	}
}
