package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.countries.ListCountryViewModel;
import com.example.fleetApp.repositories.ICountryRepository;
import com.example.fleetApp.services.interfaces.ICountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {
    private final ICountryRepository countryRepository;

    public CountryService(ICountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<ListCountryViewModel> getCountries() {
        return this.countryRepository.findAll()
                .stream()
                .map(c -> new ListCountryViewModel()
                        .setId(c.getId())
                        .setNationality(c.getNationality())
                        .setDescription(c.getDescription())
                        .setContinent(c.getContinent())
                        .setCode(c.getCode())
                        .setCapital(c.getCapital()))
                .toList();
    }
}
