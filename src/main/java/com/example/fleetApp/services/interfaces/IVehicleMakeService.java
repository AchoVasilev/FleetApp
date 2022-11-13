package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.vehicle.vehicleMakes.VehicleMakeFormModel;
import com.example.fleetApp.dto.vehicle.vehicleMakes.VehicleMakeViewModel;

import java.util.List;
import java.util.Optional;

public interface IVehicleMakeService {
    List<VehicleMakeViewModel> getAll();

    void add(VehicleMakeFormModel formModel);

    Optional<VehicleMakeViewModel> findById(Long id);

    boolean editById(Long id, VehicleMakeFormModel model);

    boolean deleteById(Long id);
}
