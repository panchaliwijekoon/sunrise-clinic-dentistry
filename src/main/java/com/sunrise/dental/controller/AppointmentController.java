package com.sunrise.dental.controller;

import com.sunrise.dental.model.Appointment;
import com.sunrise.dental.repository.AppointmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")

public class AppointmentController {
    private final AppointmentRepository appointmentRepository;
    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    @GetMapping("/register")
    public String showRegisterForm() {
        return "appointments/register";
    }
    @PostMapping("/save")
    public String saveAppointment(Appointment appointment){
        if (appointment.getStatus() == null || appointment.getStatus().isBlank()) {
            appointment.setStatus("SCHEDULED");
        }
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping
    public String showAppointments(Model model){
        model.addAttribute("appointments",appointmentRepository.findAll());
        return "appointments/list";
    }
    @GetMapping("/edit/{id}")
    public String showEditAppointment(@PathVariable Long id, Model model){
        Appointment appointment= appointmentRepository.findById(id).orElseThrow(()->new RuntimeException("appointment not found"));
        model.addAttribute("appointment",appointment);
        return "appointments/edit";
    }
    @PostMapping("/update/{id}")
    public String updateAppointment(@PathVariable Long id, @ModelAttribute Appointment updatedAppointment){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setPatientName(updatedAppointment.getPatientName());
        appointment.setDentistName(updatedAppointment.getDentistName());
        appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
        appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
        appointment.setNotes(updatedAppointment.getNotes());

        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }
    @GetMapping("/cancel/{id}")
    public String cancelAppointment(@PathVariable Long id){
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus("CANCELLED");
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }
}
