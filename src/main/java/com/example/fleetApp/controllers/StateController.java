package com.example.fleetApp.controllers;

import com.example.fleetApp.dto.states.AddStateFormModel;
import com.example.fleetApp.dto.states.StateModel;
import com.example.fleetApp.services.interfaces.ICountryService;
import com.example.fleetApp.services.interfaces.IStateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/states")
public class StateController {
    private final IStateService stateService;
    private final ICountryService countryService;
    public StateController(IStateService stateService, ICountryService countryService) {
        this.stateService = stateService;
        this.countryService = countryService;
    }

    @GetMapping
    public String getStates(Model model) {
        var states = this.stateService.getStates();
        model.addAttribute("states", states);

        var countries = this.countryService.getCountries();
        model.addAttribute("countries", countries);

        return "states";
    }

    @PostMapping("/addState")
    public String addState(AddStateFormModel state) {
        this.stateService.addState(state);

        return "redirect:/states";
    }
}
