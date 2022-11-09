package com.example.fleetApp.controllers;

import com.example.fleetApp.dto.countries.AddCountryFormModel;
import com.example.fleetApp.dto.countries.CountryModel;
import com.example.fleetApp.services.interfaces.ICountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/countries")
public class CountryController {
    private final ICountryService countryService;

    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public String getCountries(Model model) {
        var countries = this.countryService.getCountries();
        model.addAttribute("countries", countries);

        return "countries";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CountryModel> findById(@PathVariable("id") Long id) {
        var countryOpt = this.countryService.findById(id);

        if (countryOpt.isPresent()) {
            return ResponseEntity.ok(countryOpt.get());
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/addCountry")
    public String addCountry(AddCountryFormModel formModel) {
        this.countryService.addCountry(formModel);

        return "redirect:/countries";
    }
}
