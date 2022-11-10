package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.locations.LocationFormModel;
import com.example.fleetApp.dto.locations.LocationViewModel;
import com.example.fleetApp.models.Location;
import com.example.fleetApp.repositories.ILocationRepository;
import com.example.fleetApp.services.interfaces.ILocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService implements ILocationService {
    private final ILocationRepository locationRepository;

    public LocationService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationViewModel> getStates() {
        return this.locationRepository
                .findAll()
                .stream()
                .map(location -> new LocationViewModel()
                        .setAddress(location.getAddress())
                        .setDescription(location.getDescription())
                        .setCity(location.getCity())
                        .setDetails(location.getDetails())
                        .setId(location.getId())
                )
                .toList();
    }

    public void addState(LocationFormModel locationModel) {
        var location = new Location();
        location
                .setStateId(locationModel.getStateId())
                .setCountryId(locationModel.getCountryId())
                .setCity(locationModel.getCity())
                .setAddress(locationModel.getAddress())
                .setDescription(locationModel.getDescription())
                .setDetails(locationModel.getDetails());

        this.locationRepository.save(location);
    }

    public Optional<LocationViewModel> findById(Long id) {
        return this.locationRepository.findById(id)
                .map(entity -> new LocationViewModel()
                        .setId(entity.getId())
                        .setCity(entity.getCity())
                        .setDetails(entity.getDetails())
                        .setDescription(entity.getDescription())
                        .setAddress(entity.getAddress()));
    }

    public boolean editById(Long id, LocationFormModel model) {
        var entity = this.locationRepository.findById(id);
        if (entity.isPresent()) {
            var location = entity.get();
            location.setAddress(model.getAddress())
                    .setCity(model.getCity())
                    .setDescription(model.getDescription())
                    .setDetails(model.getDetails());

            this.locationRepository.save(location);

            return true;
        }

        return false;
    }

    public boolean deleteById(Long id) {
        var entityOpt = this.locationRepository.findById(id);

        if (entityOpt.isPresent()) {
            this.locationRepository.delete(entityOpt.get());

            return true;
        }

        return false;
    }
}
