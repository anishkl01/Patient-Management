package com.doctor_service.org.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor_service.org.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
	
	boolean existsByEmail(String email);
}
