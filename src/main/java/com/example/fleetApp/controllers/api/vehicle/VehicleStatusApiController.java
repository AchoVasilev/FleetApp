package com.example.fleetApp.controllers.api.vehicle;

import com.example.fleetApp.dto.vehicle.vehicleStatuses.VehicleStatusFormModel;
import com.example.fleetApp.dto.vehicle.vehicleStatuses.VehicleStatusViewModel;
import com.example.fleetApp.services.interfaces.IVehicleStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicleStatus")
public class VehicleStatusApiController {
    private final IVehicleStatusService vehicleStatusService;

    public VehicleStatusApiController(IVehicleStatusService vehicleStatusService) {
        this.vehicleStatusService = vehicleStatusService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<VehicleStatusViewModel> findById(@PathVariable("id") Long id) {
        var vehicleTypeOpt = this.vehicleStatusService.findById(id);

        return vehicleTypeOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping(value = "/editById/{id}", consumes = "application/json")
    public ResponseEntity<String> editById(@PathVariable("id") Long id, @RequestBody VehicleStatusFormModel model) {
        var edited = this.vehicleStatusService.editById(id, model);

        if (edited) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        var isDeleted = this.vehicleStatusService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}
