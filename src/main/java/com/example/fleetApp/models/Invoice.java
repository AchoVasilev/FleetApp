package com.example.fleetApp.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String remarks;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date invoiceDate;

    private Long invoiceStatusId;
    @ManyToOne
    private InvoiceStatus invoiceStatus;

    private Long clientId;
    @ManyToOne
    private Client client;

    public Long getId() {
        return id;
    }

    public Invoice setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public Invoice setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public Invoice setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    public Long getInvoiceStatusId() {
        return invoiceStatusId;
    }

    public Invoice setInvoiceStatusId(Long invoiceStatusId) {
        this.invoiceStatusId = invoiceStatusId;
        return this;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public Invoice setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
        return this;
    }

    public Long getClientId() {
        return clientId;
    }

    public Invoice setClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public Invoice setClient(Client client) {
        this.client = client;
        return this;
    }
}
