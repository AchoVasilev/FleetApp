package com.example.fleetApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicleStatus")
public class VehicleStatusController {
    @GetMapping
    public String getVehicleStatus() {
        return "vehicle-status";
    }
}
