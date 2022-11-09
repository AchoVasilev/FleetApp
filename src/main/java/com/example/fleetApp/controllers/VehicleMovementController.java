package com.example.fleetApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicleMovement")
public class VehicleMovementController {
    @GetMapping
    public String getVehicleMovements() {
        return "vehicle-movements";
    }
}
