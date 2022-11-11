package com.example.fleetApp.controllers.api;

import com.example.fleetApp.dto.locations.LocationFormModel;
import com.example.fleetApp.dto.locations.LocationViewModel;
import com.example.fleetApp.services.interfaces.ILocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
public class LocationsApiController {
    private final ILocationService locationService;

    public LocationsApiController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<LocationViewModel> findById(@PathVariable("id") Long id) {
        var countryOpt = this.locationService.findById(id);

        return countryOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping(value = "/editById/{id}", consumes = "application/json")
    public ResponseEntity<String> editById(@PathVariable("id") Long id, @RequestBody LocationFormModel model) {
        var edited = this.locationService.editById(id, model);

        if (edited) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        var isDeleted = this.locationService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}
