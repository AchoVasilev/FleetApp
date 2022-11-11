package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.vehicle.vehicleStatuses.VehicleStatusFormModel;
import com.example.fleetApp.dto.vehicle.vehicleStatuses.VehicleStatusViewModel;
import com.example.fleetApp.models.VehicleStatus;
import com.example.fleetApp.repositories.IVehicleStatusRepository;
import com.example.fleetApp.services.interfaces.IVehicleStatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService implements IVehicleStatusService {
    private final IVehicleStatusRepository vehicleStatusRepository;

    public VehicleStatusService(IVehicleStatusRepository vehicleStatusRepository) {
        this.vehicleStatusRepository = vehicleStatusRepository;
    }

    public List<VehicleStatusViewModel> getVehicleStatuses() {
        return this.vehicleStatusRepository
                .findAll()
                .stream()
                .map(vehicleType -> new VehicleStatusViewModel(
                        vehicleType.getDetails(),
                        vehicleType.getDescription(),
                        vehicleType.getId())
                )
                .toList();
    }

    public void addVehicleType(VehicleStatusFormModel formModel) {
        var vehicleStatus = new VehicleStatus();
        vehicleStatus
                .setDescription(formModel.getDescription())
                .setDetails(formModel.getDetails());

        this.vehicleStatusRepository.save(vehicleStatus);
    }

    public Optional<VehicleStatusViewModel> findById(Long id) {
        return this.vehicleStatusRepository.findById(id)
                .map(entity -> new VehicleStatusViewModel(
                        entity.getDetails(),
                        entity.getDescription(),
                        entity.getId()));
    }

    public boolean editById(Long id, VehicleStatusFormModel model) {
        var entity = this.vehicleStatusRepository.findById(id);
        if (entity.isPresent()) {
            var vehicleStatus = entity.get();
            vehicleStatus
                    .setDescription(model.getDescription())
                    .setDetails(model.getDetails());

            this.vehicleStatusRepository.save(vehicleStatus);

            return true;
        }

        return false;
    }

    public boolean deleteById(Long id) {
        var entityOpt = this.vehicleStatusRepository.findById(id);

        if (entityOpt.isPresent()) {
            this.vehicleStatusRepository.delete(entityOpt.get());

            return true;
        }

        return false;
    }
}
