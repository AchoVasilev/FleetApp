package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeFormModel;
import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeViewModel;

import java.util.List;
import java.util.Optional;

public interface IVehicleTypeService {
    List<VehicleTypeViewModel> getVehicleTypes();

    void addVehicleType(VehicleTypeFormModel formModel);

    Optional<VehicleTypeViewModel> findById(Long id);

    boolean editById(Long id, VehicleTypeFormModel model);

    boolean deleteById(Long id);
}
