package com.example.fleetApp.repositories;

import com.example.fleetApp.models.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoiceStatusRepository extends JpaRepository<InvoiceStatus, Long> {
}
