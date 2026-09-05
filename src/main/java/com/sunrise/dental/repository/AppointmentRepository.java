package com.sunrise.dental.repository;

import com.sunrise.dental.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long>{

}
