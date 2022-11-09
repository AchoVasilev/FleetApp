package com.example.fleetApp.controllers;

import com.example.fleetApp.services.interfaces.ICountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
