package com.appointment_service.org.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDTO {
	private String id;
	private String name;
	private String specialization;
	private String timings;
	private String email;
	private String phone;
	private String availableDays;
}
