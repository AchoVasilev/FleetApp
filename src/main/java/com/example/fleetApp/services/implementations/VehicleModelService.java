package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.vehicle.vehicleModels.VehicleModelFormModel;
import com.example.fleetApp.dto.vehicle.vehicleModels.VehicleModelViewModel;
import com.example.fleetApp.models.VehicleModel;
import com.example.fleetApp.repositories.IVehicleModelRepository;
import com.example.fleetApp.services.interfaces.IVehicleModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService implements IVehicleModelService {
    private final IVehicleModelRepository vehicleModelRepository;

    public VehicleModelService(IVehicleModelRepository vehicleModelRepository) {
        this.vehicleModelRepository = vehicleModelRepository;
    }

    public List<VehicleModelViewModel> getAll() {
        return this.vehicleModelRepository
                .findAll()
                .stream()
                .map(vehicleType -> new VehicleModelViewModel(
                        vehicleType.getDetails(),
                        vehicleType.getDescription(),
                        vehicleType.getId())
                )
                .toList();
    }

    public void add(VehicleModelFormModel formModel) {
        var vehicleModel = new VehicleModel();
        vehicleModel
                .setDescription(formModel.getDescription())
                .setDetails(formModel.getDetails());

        this.vehicleModelRepository.save(vehicleModel);
    }

    public Optional<VehicleModelViewModel> findById(Long id) {
        return this.vehicleModelRepository.findById(id)
                .map(entity -> new VehicleModelViewModel(
                        entity.getDetails(),
                        entity.getDescription(),
                        entity.getId()));
    }

    public boolean editById(Long id, VehicleModelFormModel model) {
        var entityOpt = this.vehicleModelRepository.findById(id);
        if (entityOpt.isPresent()) {
            var entity = entityOpt.get();
            entity
                    .setDescription(model.getDescription())
                    .setDetails(model.getDetails());

            this.vehicleModelRepository.save(entity);

            return true;
        }

        return false;
    }

    public boolean deleteById(Long id) {
        var entityOpt = this.vehicleModelRepository.findById(id);

        if (entityOpt.isPresent()) {
            this.vehicleModelRepository.delete(entityOpt.get());

            return true;
        }

        return false;
    }
}
