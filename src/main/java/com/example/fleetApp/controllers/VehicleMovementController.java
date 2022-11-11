package com.example.fleetApp.controllers;

import com.example.fleetApp.dto.vehicle.vehicleMovements.VehicleMovementFormModel;
import com.example.fleetApp.services.interfaces.IVehicleMovementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicleMovement")
public class VehicleMovementController {
    private final IVehicleMovementService vehicleMovementService;

    public VehicleMovementController(IVehicleMovementService vehicleMovementService) {
        this.vehicleMovementService = vehicleMovementService;
    }

    @GetMapping
    public String getVehicleMovement(Model model) {
        var vehicleStatuses = this.vehicleMovementService.getAll();
        model.addAttribute("vehicleMovements", vehicleStatuses);

        return "vehicle-movements";
    }

    @PostMapping
    public String addVehicleMovement(VehicleMovementFormModel model) {
        this.vehicleMovementService.add(model);

        return "redirect:/vehicleStatus";
    }
}
