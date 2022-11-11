package com.example.fleetApp.controllers.api.vehicle;

import com.example.fleetApp.dto.vehicle.vehicleMovements.VehicleMovementFormModel;
import com.example.fleetApp.dto.vehicle.vehicleMovements.VehicleMovementViewModel;
import com.example.fleetApp.services.interfaces.IVehicleMovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicleMovement")
public class VehicleMovementApiController {
    private final IVehicleMovementService vehicleMovementService;

    public VehicleMovementApiController(IVehicleMovementService vehicleMovementService) {
        this.vehicleMovementService = vehicleMovementService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<VehicleMovementViewModel> findById(@PathVariable("id") Long id) {
        var modelOpt = this.vehicleMovementService.findById(id);

        return modelOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping(value = "/editById/{id}", consumes = "application/json")
    public ResponseEntity<String> editById(@PathVariable("id") Long id, @RequestBody VehicleMovementFormModel model) {
        var edited = this.vehicleMovementService.editById(id, model);

        if (edited) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        var isDeleted = this.vehicleMovementService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}
