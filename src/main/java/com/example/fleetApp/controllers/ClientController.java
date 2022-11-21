package com.example.fleetApp.controllers;

import com.example.fleetApp.dto.clients.ClientFormModel;
import com.example.fleetApp.services.interfaces.IClientService;
import com.example.fleetApp.services.interfaces.ICountryService;
import com.example.fleetApp.services.interfaces.IStateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final IClientService clientService;
    private final IStateService stateService;
    private final ICountryService countryService;

    public ClientController(IClientService clientService, IStateService stateService, ICountryService countryService) {
        this.clientService = clientService;
        this.stateService = stateService;
        this.countryService = countryService;
    }

    @GetMapping
    public String getClients(Model model) {
        var clients = this.clientService.getAll();
        model.addAttribute("clients", clients);

        var states = this.stateService.getStates();
        model.addAttribute("states", states);

        var countries = this.countryService.getCountries();
        model.addAttribute("countries", countries);

        return "clients";
    }

    @PostMapping("/addClient")
    public String addClient(ClientFormModel client) {
        this.clientService.add(client);

        return "redirect:/clients";
    }
}
