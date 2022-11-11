package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.vehicle.vehicleMovements.VehicleMovementFormModel;
import com.example.fleetApp.dto.vehicle.vehicleMovements.VehicleMovementViewModel;
import com.example.fleetApp.models.VehicleMovement;
import com.example.fleetApp.repositories.IVehicleMovementRepository;
import com.example.fleetApp.services.interfaces.IVehicleMovementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService implements IVehicleMovementService {
    private final IVehicleMovementRepository vehicleMovementRepository;

    public VehicleMovementService(IVehicleMovementRepository vehicleMovementRepository) {
        this.vehicleMovementRepository = vehicleMovementRepository;
    }

    public List<VehicleMovementViewModel> getAll() {
        return this.vehicleMovementRepository
                .findAll()
                .stream()
                .map(vehicleType -> new VehicleMovementViewModel(
                        vehicleType.getDetails(),
                        vehicleType.getDescription(),
                        vehicleType.getId())
                )
                .toList();
    }

    public void add(VehicleMovementFormModel formModel) {
        var vehicleMovement = new VehicleMovement();
        vehicleMovement
                .setDescription(formModel.getDescription())
                .setDetails(formModel.getDetails());

        this.vehicleMovementRepository.save(vehicleMovement);
    }

    public Optional<VehicleMovementViewModel> findById(Long id) {
        return this.vehicleMovementRepository.findById(id)
                .map(entity -> new VehicleMovementViewModel(
                        entity.getDetails(),
                        entity.getDescription(),
                        entity.getId()));
    }

    public boolean editById(Long id, VehicleMovementFormModel model) {
        var entityOpt = this.vehicleMovementRepository.findById(id);
        if (entityOpt.isPresent()) {
            var entity = entityOpt.get();
            entity
                    .setDescription(model.getDescription())
                    .setDetails(model.getDetails());

            this.vehicleMovementRepository.save(entity);

            return true;
        }

        return false;
    }

    public boolean deleteById(Long id) {
        var entityOpt = this.vehicleMovementRepository.findById(id);

        if (entityOpt.isPresent()) {
            this.vehicleMovementRepository.delete(entityOpt.get());

            return true;
        }

        return false;
    }
}
