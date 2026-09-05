package com.sunrise.dental.controller;

import com.sunrise.dental.model.Invoice;
import com.sunrise.dental.repository.InvoiceRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class BillingController {
    private final InvoiceRepository invoiceRepository;
    public BillingController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
    @GetMapping("/billing")
    public String showBillingPage(){
        return "billing/calculate";
    }
    @PostMapping("/billing/calculate")
    public String calculateBill(@RequestParam String patientName,
                                @RequestParam String treatment,
                                @RequestParam BigDecimal amount,
                                @RequestParam(defaultValue = "0")
                                BigDecimal discount, Model model) {
        BigDecimal total = amount.subtract(discount);
        Invoice invoice = new Invoice();
        invoice.setPatientName(patientName);
        invoice.setTreatment(treatment);
        invoice.setAmount(amount);
        invoice.setDiscount(discount);
        invoice.setTotal(total);
        invoice.setBillDate(LocalDate.now());
        invoiceRepository.save(invoice);

        model.addAttribute("invoice", invoice);
        return "billing/receipt";
    }
    @GetMapping("/receipts")
    public String showReceiptPage(Model model){
        model.addAttribute("invoices", invoiceRepository.findAll());
        return "billing/receipt";
    }
    @GetMapping("/receipt/{id}")
    public String showReceiptPage(@PathVariable Long id, Model model){
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(()-> new RuntimeException("invoice not found"));
        model.addAttribute("invoice",invoice);
        return "billing/receipt";
    }
}
