package com.example.fleetApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicleHires")
public class VehicleHireController {
    @GetMapping
    public String getVehicleHires() {
        return "vehicle-hires";
    }
}
