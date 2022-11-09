package com.example.fleetApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoiceStatus")
public class InvoiceStatusController {
    @GetMapping
    public String getInvoiceStatus() {
        return "invoice-status";
    }
}
