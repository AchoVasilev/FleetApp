package com.example.fleetApp.controllers.api;

import com.example.fleetApp.dto.states.StateModel;
import com.example.fleetApp.services.interfaces.IStateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/states")
public class StatesApiController {
    private final IStateService stateService;

    public StatesApiController(IStateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<StateModel> findById(@PathVariable("id") Long id) {
        var countryOpt = this.stateService.findById(id);

        return countryOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping(value = "/editById/{id}", consumes = "application/json")
    public ResponseEntity<String> editById(@PathVariable("id") Long id, @RequestBody StateModel model) {
        var edited = this.stateService.editById(id, model);

        if (edited) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        var isDeleted = this.stateService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}
