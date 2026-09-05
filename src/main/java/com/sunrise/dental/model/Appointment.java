package com.sunrise.dental.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")

public class Appointment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String dentistName;
    private String status;
    private String notes;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    public Appointment() {}
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getPatientName() {return patientName;}
    public void setPatientName(String patientName) {this.patientName = patientName;}
    public String getDentistName() {return dentistName;}
    public void setDentistName(String dentistName) {this.dentistName = dentistName;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public String getNotes() {return notes;}
    public void setNotes(String notes) {this.notes = notes;}
    public LocalDate getAppointmentDate() {return appointmentDate;}
    public void setAppointmentDate(LocalDate appointmentDate) {this.appointmentDate = appointmentDate;}
    public LocalTime getAppointmentTime() {return appointmentTime;}
    public void setAppointmentTime(LocalTime appointmentTime) {this.appointmentTime = appointmentTime;}


}
