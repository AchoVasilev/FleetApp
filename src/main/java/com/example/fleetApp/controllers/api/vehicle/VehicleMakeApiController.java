package com.example.fleetApp.controllers.api.vehicle;

import com.example.fleetApp.dto.vehicle.vehicleMakes.VehicleMakeFormModel;
import com.example.fleetApp.dto.vehicle.vehicleMakes.VehicleMakeViewModel;
import com.example.fleetApp.services.interfaces.IVehicleMakeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicleMake")
public class VehicleMakeApiController {
    private final IVehicleMakeService vehicleMakeService;

    public VehicleMakeApiController(IVehicleMakeService vehicleMakeService) {
        this.vehicleMakeService = vehicleMakeService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<VehicleMakeViewModel> findById(@PathVariable("id") Long id) {
        var modelOpt = this.vehicleMakeService.findById(id);

        return modelOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping(value = "/editById/{id}", consumes = "application/json")
    public ResponseEntity<String> editById(@PathVariable("id") Long id, @RequestBody VehicleMakeFormModel model) {
        var edited = this.vehicleMakeService.editById(id, model);

        if (edited) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        var isDeleted = this.vehicleMakeService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}
