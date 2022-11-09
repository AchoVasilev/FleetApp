package com.example.fleetApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicleMaintenance")
public class VehicleMaintenanceController {
    @GetMapping
    public String getVehicleMaintenance() {
        return "vehicle-maintenance";
    }
}
