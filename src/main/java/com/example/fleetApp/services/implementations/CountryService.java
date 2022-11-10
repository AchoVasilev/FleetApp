package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.countries.AddCountryFormModel;
import com.example.fleetApp.dto.countries.CountryModel;
import com.example.fleetApp.models.Country;
import com.example.fleetApp.repositories.ICountryRepository;
import com.example.fleetApp.services.interfaces.ICountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    private final ICountryRepository countryRepository;

    public CountryService(ICountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryModel> getCountries() {
        return this.countryRepository.findAll()
                .stream()
                .map(c -> new CountryModel()
                        .setId(c.getId())
                        .setNationality(c.getNationality())
                        .setDescription(c.getDescription())
                        .setContinent(c.getContinent())
                        .setCode(c.getCode())
                        .setCapital(c.getCapital()))
                .toList();
    }

    public void addCountry(AddCountryFormModel formModel) {
        var country = new Country()
                .setCapital(formModel.getCapital())
                .setCode(formModel.getCode())
                .setContinent(formModel.getContinent())
                .setNationality(formModel.getNationality())
                .setDescription(formModel.getDescription());

        this.countryRepository.save(country);
    }

    public Optional<CountryModel> findById(Long id) {
        return this.countryRepository.findById(id)
                .map(entity -> new CountryModel()
                        .setCapital(entity.getCapital())
                        .setDescription(entity.getDescription())
                        .setNationality(entity.getNationality())
                        .setCode(entity.getCode())
                        .setId(entity.getId())
                        .setContinent(entity.getContinent()));
    }

    public boolean editById(Long id, CountryModel model) {
        var entityOpt = this.countryRepository.findById(id);
        if (entityOpt.isPresent()) {
            var entity = entityOpt.get();

            entity.setCode(model.getCode())
                    .setCapital(model.getCapital())
                    .setContinent(model.getContinent())
                    .setNationality(model.getNationality())
                    .setDescription(model.getDescription());

            this.countryRepository.save(entity);

            return true;
        }

        return false;
    }

    public boolean deleteById(Long id) {
        var entityOpt = this.countryRepository.findById(id);

        if (entityOpt.isPresent()) {
            this.countryRepository.delete(entityOpt.get());

            return true;
        }

        return false;
    }
}
