package com.patient_management.org.dto;

import com.patient_management.org.dto.validators.CreatePatientValidatorGroup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDTO {
	
	@NotBlank(message = "Name is required")
	@Size(max = 100,message = "Name cannot exceed 100 characters")
	private String name;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Enter valid email")
	private String email;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotBlank(message = "Date of Birth is required")
	private String dateOfBirth;
	
	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female or Other")
	private String gender;
	
	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^\\d{10}$", message = "Phone must be 10 digits")
	private String phone;
	
	@NotBlank(groups = CreatePatientValidatorGroup.class, message = "Registered date is required")
	private String registeredDate;
}
