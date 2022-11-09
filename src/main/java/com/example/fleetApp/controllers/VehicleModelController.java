package com.example.fleetApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicleModels")
public class VehicleModelController {
    @GetMapping
    public String getVehicleModels() {
        return "vehicle-models";
    }
}
