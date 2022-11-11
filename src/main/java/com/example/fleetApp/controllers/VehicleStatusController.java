package com.example.fleetApp.controllers;

import com.example.fleetApp.dto.vehicle.vehicleStatuses.VehicleStatusFormModel;
import com.example.fleetApp.services.interfaces.IVehicleStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicleStatus")
public class VehicleStatusController {
    private final IVehicleStatusService vehicleStatusService;

    public VehicleStatusController(IVehicleStatusService vehicleStatusService) {
        this.vehicleStatusService = vehicleStatusService;
    }

    @GetMapping
    public String getVehicleStatus(Model model) {
        var vehicleStatuses = this.vehicleStatusService.getVehicleTypes();
        model.addAttribute("vehicleStatuses", vehicleStatuses);

        return "vehicle-status";
    }

    @PostMapping
    public String addVehicleStatus(VehicleStatusFormModel model) {
        this.vehicleStatusService.addVehicleType(model);

        return "redirect:/vehicleStatus";
    }
}
