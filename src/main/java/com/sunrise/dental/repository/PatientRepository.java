package com.sunrise.dental.repository;

import com.sunrise.dental.model.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<patient,Integer> {
}
