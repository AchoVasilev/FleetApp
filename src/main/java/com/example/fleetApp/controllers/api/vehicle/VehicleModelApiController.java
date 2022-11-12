package com.example.fleetApp.controllers.api.vehicle;

import com.example.fleetApp.dto.vehicle.vehicleModels.VehicleModelFormModel;
import com.example.fleetApp.dto.vehicle.vehicleModels.VehicleModelViewModel;
import com.example.fleetApp.services.interfaces.IVehicleModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicleModels")
public class VehicleModelApiController {
    private final IVehicleModelService vehicleModelService;

    public VehicleModelApiController(IVehicleModelService vehicleModelService) {
        this.vehicleModelService = vehicleModelService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<VehicleModelViewModel> findById(@PathVariable("id") Long id) {
        var modelOpt = this.vehicleModelService.findById(id);

        return modelOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping(value = "/editById/{id}", consumes = "application/json")
    public ResponseEntity<String> editById(@PathVariable("id") Long id, @RequestBody VehicleModelFormModel model) {
        var edited = this.vehicleModelService.editById(id, model);

        if (edited) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        var isDeleted = this.vehicleModelService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}
