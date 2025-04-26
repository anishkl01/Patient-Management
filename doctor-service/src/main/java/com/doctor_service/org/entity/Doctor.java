package com.doctor_service.org.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID doctorId;
	
	@NotNull
	private String doctorName;
	
	@NotNull
	private String specialization;
	
	@NotNull
	private String email;
	
	@NotNull
	private String phone;
	
	@NotNull
	private String availableDays;
	
	@NotNull
	private String timings;
		
	
}
