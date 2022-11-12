package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.vehicle.vehicleModels.VehicleModelFormModel;
import com.example.fleetApp.dto.vehicle.vehicleModels.VehicleModelViewModel;

import java.util.List;
import java.util.Optional;

public interface IVehicleModelService {
    List<VehicleModelViewModel> getAll();

    void add(VehicleModelFormModel formModel);

    Optional<VehicleModelViewModel> findById(Long id);

    boolean editById(Long id, VehicleModelFormModel model);

    boolean deleteById(Long id);
}
