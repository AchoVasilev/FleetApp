package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.vehicle.vehicleMovements.VehicleMovementFormModel;
import com.example.fleetApp.dto.vehicle.vehicleMovements.VehicleMovementViewModel;

import java.util.List;
import java.util.Optional;

public interface IVehicleMovementService {
    List<VehicleMovementViewModel> getAll();

    void add(VehicleMovementFormModel formModel);

    Optional<VehicleMovementViewModel> findById(Long id);

    boolean editById(Long id, VehicleMovementFormModel model);

    boolean deleteById(Long id);
}
