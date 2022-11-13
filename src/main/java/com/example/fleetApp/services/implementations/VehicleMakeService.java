package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.vehicle.vehicleMakes.VehicleMakeFormModel;
import com.example.fleetApp.dto.vehicle.vehicleMakes.VehicleMakeViewModel;
import com.example.fleetApp.models.VehicleMake;
import com.example.fleetApp.repositories.IVehicleMakeRepository;
import com.example.fleetApp.services.interfaces.IVehicleMakeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService implements IVehicleMakeService {
    private final IVehicleMakeRepository vehicleMakeRepository;

    public VehicleMakeService(IVehicleMakeRepository vehicleMakeRepository) {
        this.vehicleMakeRepository = vehicleMakeRepository;
    }

    public List<VehicleMakeViewModel> getAll() {
        return this.vehicleMakeRepository
                .findAll()
                .stream()
                .map(vehicleType -> new VehicleMakeViewModel(
                        vehicleType.getDetails(),
                        vehicleType.getDescription(),
                        vehicleType.getId())
                )
                .toList();
    }

    public void add(VehicleMakeFormModel formModel) {
        var vehicleMake = new VehicleMake();
        vehicleMake
                .setDescription(formModel.getDescription())
                .setDetails(formModel.getDetails());

        this.vehicleMakeRepository.save(vehicleMake);
    }

    public Optional<VehicleMakeViewModel> findById(Long id) {
        return this.vehicleMakeRepository.findById(id)
                .map(entity -> new VehicleMakeViewModel(
                        entity.getDetails(),
                        entity.getDescription(),
                        entity.getId()));
    }

    public boolean editById(Long id, VehicleMakeFormModel model) {
        var entityOpt = this.vehicleMakeRepository.findById(id);
        if (entityOpt.isPresent()) {
            var entity = entityOpt.get();
            entity
                    .setDescription(model.getDescription())
                    .setDetails(model.getDetails());

            this.vehicleMakeRepository.save(entity);

            return true;
        }

        return false;
    }

    public boolean deleteById(Long id) {
        var entityOpt = this.vehicleMakeRepository.findById(id);

        if (entityOpt.isPresent()) {
            this.vehicleMakeRepository.delete(entityOpt.get());

            return true;
        }

        return false;
    }
}
