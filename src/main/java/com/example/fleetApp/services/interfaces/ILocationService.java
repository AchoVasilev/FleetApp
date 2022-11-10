package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.locations.LocationFormModel;
import com.example.fleetApp.dto.locations.LocationViewModel;

import java.util.List;
import java.util.Optional;

public interface ILocationService {
    List<LocationViewModel> getStates();

    void addState(LocationFormModel locationModel);

    Optional<LocationViewModel> findById(Long id);

    boolean editById(Long id, LocationFormModel model);

    boolean deleteById(Long id);
}
