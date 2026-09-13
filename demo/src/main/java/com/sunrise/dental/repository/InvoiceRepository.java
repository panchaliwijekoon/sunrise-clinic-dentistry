package com.sunrise.dental.repository;

import com.sunrise.dental.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;


public interface InvoiceRepository extends JpaRepository<Invoice,Long>{

    List<Invoice> findByBillDateBetween(LocalDate fromDate, LocalDate toDate);


}
