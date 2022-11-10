package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.countries.AddCountryFormModel;
import com.example.fleetApp.dto.countries.CountryModel;

import java.util.List;
import java.util.Optional;

public interface ICountryService {
    List<CountryModel> getCountries();

    void addCountry(AddCountryFormModel formModel);

    Optional<CountryModel> findById(Long id);

    boolean editById(Long id, CountryModel model);
}
