package com.appointment_service.org.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.appointment_service.org.enums.AppointmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID aptId;
	
	@NotNull
	private UUID patientId;
	
	@NotNull
	private UUID doctorId;
	
	@NotNull
	private LocalTime aptTime;
	
	@NotNull
	private LocalDate aptDate;
	
	private String reason;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;
}
