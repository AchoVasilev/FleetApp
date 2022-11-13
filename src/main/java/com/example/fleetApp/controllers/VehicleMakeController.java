package com.example.fleetApp.controllers;

import com.example.fleetApp.dto.vehicle.vehicleMakes.VehicleMakeFormModel;
import com.example.fleetApp.services.interfaces.IVehicleMakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicleMake")
public class VehicleMakeController {
    private final IVehicleMakeService vehicleMakeService;

    public VehicleMakeController(IVehicleMakeService vehicleMakeService) {
        this.vehicleMakeService = vehicleMakeService;
    }

    @GetMapping
    public String getVehicleModels(Model model) {
        var vehicleMakes = this.vehicleMakeService.getAll();
        model.addAttribute("vehicleMakes", vehicleMakes);

        return "vehicle-makes";
    }

    @PostMapping
    public String addVehicleMovement(VehicleMakeFormModel model) {
        this.vehicleMakeService.add(model);

        return "redirect:/vehicleMake";
    }
}
