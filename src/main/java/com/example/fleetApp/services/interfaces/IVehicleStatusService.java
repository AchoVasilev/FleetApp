package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.vehicle.vehicleStatuses.VehicleStatusFormModel;
import com.example.fleetApp.dto.vehicle.vehicleStatuses.VehicleStatusViewModel;

import java.util.List;
import java.util.Optional;

public interface IVehicleStatusService {
    List<VehicleStatusViewModel> getVehicleStatuses();

    void addVehicleType(VehicleStatusFormModel formModel);

    Optional<VehicleStatusViewModel> findById(Long id);

    boolean editById(Long id, VehicleStatusFormModel model);

    boolean deleteById(Long id);
}
