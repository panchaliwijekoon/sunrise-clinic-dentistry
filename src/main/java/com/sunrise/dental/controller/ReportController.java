package com.sunrise.dental.controller;

import com.sunrise.dental.model.Appointment;
import com.sunrise.dental.model.Invoice;
import com.sunrise.dental.repository.AppointmentRepository;
import com.sunrise.dental.repository.InvoiceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;
@Controller

public class ReportController {
    private final AppointmentRepository appointmentRepository;
    private final InvoiceRepository invoiceRepository;
    public ReportController(AppointmentRepository appointmentRepository, InvoiceRepository invoiceRepository) {
        this.appointmentRepository = appointmentRepository;
        this.invoiceRepository = invoiceRepository;
    }
    @GetMapping("/reports")
    public String showReports(Model model) {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<Invoice> invoices = invoiceRepository.findAll();

        long totalAppointments= appointments.size();
        long cancelledAppointments= appointments.stream().filter(a-> "CANCELLED".equals(a.getStatus())).count();
        Long scheduledAppointments= appointments.stream().filter(a-> "SCHEDULED".equals(a.getStatus())).count();

        long totalBills = invoices.size();

        BigDecimal totalRevenue = invoices.stream().map(Invoice::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("totalAppointments", totalAppointments);
        model.addAttribute("scheduledAppointments", scheduledAppointments);
        model.addAttribute("cancelledAppointments", cancelledAppointments);
        model.addAttribute("totalRevenue", totalRevenue);
        model.addAttribute("totalBills", invoices.size());
        return "reports";
    }
}

