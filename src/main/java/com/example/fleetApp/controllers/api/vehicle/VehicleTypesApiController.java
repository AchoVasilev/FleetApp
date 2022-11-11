package com.example.fleetApp.controllers.api.vehicle;

import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeFormModel;
import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeViewModel;
import com.example.fleetApp.services.interfaces.IVehicleTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicleType")
public class VehicleTypesApiController {
    private final IVehicleTypeService vehicleTypeService;

    public VehicleTypesApiController(IVehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<VehicleTypeViewModel> findById(@PathVariable("id") Long id) {
        var vehicleTypeOpt = this.vehicleTypeService.findById(id);

        return vehicleTypeOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping(value = "/editById/{id}", consumes = "application/json")
    public ResponseEntity<String> editById(@PathVariable("id") Long id, @RequestBody VehicleTypeFormModel model) {
        var edited = this.vehicleTypeService.editById(id, model);

        if (edited) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        var isDeleted = this.vehicleTypeService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}
