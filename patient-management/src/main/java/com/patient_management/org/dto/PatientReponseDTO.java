package com.patient_management.org.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientReponseDTO {
	
	private String id;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String gender;
	private String dateOfBirth;
}
