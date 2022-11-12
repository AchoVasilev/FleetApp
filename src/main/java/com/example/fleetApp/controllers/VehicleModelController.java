package com.example.fleetApp.controllers;

import com.example.fleetApp.dto.vehicle.vehicleModels.VehicleModelFormModel;
import com.example.fleetApp.services.interfaces.IVehicleModelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicleModels")
public class VehicleModelController {
    private final IVehicleModelService vehicleModelService;

    public VehicleModelController(IVehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    }

    @GetMapping
    public String getVehicleModels(Model model) {
        var vehicleModels = this.vehicleModelService.getAll();
        model.addAttribute("vehicleModels", vehicleModels);

        return "vehicle-models";
    }

    @PostMapping
    public String addVehicleMovement(VehicleModelFormModel model) {
        this.vehicleModelService.add(model);

        return "redirect:/vehicleModels";
    }
}
