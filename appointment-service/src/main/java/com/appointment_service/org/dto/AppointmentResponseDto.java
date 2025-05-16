package com.appointment_service.org.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointmentResponseDto {
	
	private String aptId;
	
	private String patientId;
	
	private String doctorId;
	
	private String aptTime;
	
	private String aptDate;
	
	private String reason;
	
	private String status;
}
