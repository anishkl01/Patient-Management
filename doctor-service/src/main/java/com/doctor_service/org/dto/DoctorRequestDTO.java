package com.doctor_service.org.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDTO {

	@NotBlank(message = "Name is required")
	@Size(max = 100, message = "Name exceeds 100 characters")
	private String name;
	
	@NotBlank(message = "Specialization is required")
	private String specialization;
	
	@Email(message = "Enter a valid email")
	private String email;
	
	@Pattern(regexp = "^\\d{10}$", message = "Phone must be 10 digits")
	private String phone;
	
	@NotBlank(message = "Available days is required")
	private String availableDays;
	
	@NotBlank(message = "Timings is required")
	private String timings;
}
