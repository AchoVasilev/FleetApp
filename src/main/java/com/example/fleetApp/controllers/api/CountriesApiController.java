package com.example.fleetApp.controllers.api;

import com.example.fleetApp.dto.countries.CountryModel;
import com.example.fleetApp.services.interfaces.ICountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/countries")
public class CountriesApiController {
    private final ICountryService countryService;

    public CountriesApiController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CountryModel> findById(@PathVariable("id") Long id) {
        var countryOpt = this.countryService.findById(id);

        return countryOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping(value = "/editById/{id}", consumes = "application/json")
    public ResponseEntity<String> editById(@PathVariable("id") Long id, @RequestBody CountryModel model) {
        var edited = this.countryService.editById(id, model);

        if (edited) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        var isDeleted = this.countryService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}
