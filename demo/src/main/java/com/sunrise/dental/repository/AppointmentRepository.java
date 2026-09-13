package com.sunrise.dental.repository;

import com.sunrise.dental.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long>{

    List<Appointment> findByAppointmentDateBetween(LocalDate fromDate, LocalDate toDate);

    
//MAKING SURE THE TIMES EACH APPOINTMENT IS GETTING WONT BE CLASHING
    Boolean existsByDentistNameAndAppointmentDateAndAppointmentTimeAndStatusNot(
            String dentistName,
            LocalDate appointmentDate,
            LocalTime appointmentTime,
            String status
    );

}
