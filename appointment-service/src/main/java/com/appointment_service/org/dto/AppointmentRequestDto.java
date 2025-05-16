package com.appointment_service.org.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.appointment_service.org.enums.AppointmentStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequestDto {
	
	@NotNull(message = "Patient can't be null")
	private UUID patientId;
	
	@NotNull(message = "Doctor can't be null")
	private UUID doctorId;
	
	private LocalTime aptTime;
	
	private LocalDate aptDate;
	
	private String reason;
	
	private AppointmentStatus status;
}
