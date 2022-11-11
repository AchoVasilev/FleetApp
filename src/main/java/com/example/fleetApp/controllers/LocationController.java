package com.example.fleetApp.controllers;

import com.example.fleetApp.dto.locations.LocationFormModel;
import com.example.fleetApp.services.interfaces.ICountryService;
import com.example.fleetApp.services.interfaces.ILocationService;
import com.example.fleetApp.services.interfaces.IStateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/locations")
public class LocationController {
    private final ILocationService locationService;
    private final IStateService stateService;
    private final ICountryService countryService;

    public LocationController(ILocationService locationService, IStateService stateService, ICountryService countryService) {
        this.locationService = locationService;
        this.stateService = stateService;
        this.countryService = countryService;
    }

    @GetMapping
    public String getLocations(Model model) {
        var locations = this.locationService.getLocations();
        model.addAttribute("locations", locations);

        var states = this.stateService.getStates();
        model.addAttribute("states", states);

        var countries = this.countryService.getCountries();
        model.addAttribute("countries", countries);

        return "locations";
    }

    @PostMapping
    public String addLocation(LocationFormModel model) {
        this.locationService.addLocation(model);

        return "redirect:/locations";
    }
}
