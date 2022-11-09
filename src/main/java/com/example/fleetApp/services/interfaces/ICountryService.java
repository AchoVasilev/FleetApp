package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.countries.ListCountryViewModel;

import java.util.List;

public interface ICountryService {
    List<ListCountryViewModel> getCountries();
}
