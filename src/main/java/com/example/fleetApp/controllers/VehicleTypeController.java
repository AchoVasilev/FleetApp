package com.example.fleetApp.controllers;

import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeFormModel;
import com.example.fleetApp.services.interfaces.IVehicleTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicleType")
public class VehicleTypeController {
    private final IVehicleTypeService vehicleTypeService;

    public VehicleTypeController(IVehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping
    public String getVehicleTypes(Model model) {
        var vehicleTypes = this.vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes", vehicleTypes);

        return "vehicle-types";
    }

    @PostMapping
    public String addVehicleStatus(VehicleTypeFormModel model) {
        this.vehicleTypeService.addVehicleType(model);

        return "redirect:/vehicleType";
    }
}
