package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeFormModel;
import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeViewModel;
import com.example.fleetApp.models.VehicleType;
import com.example.fleetApp.repositories.IVehicleTypeRepository;
import com.example.fleetApp.services.interfaces.IVehicleTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService implements IVehicleTypeService {
    private final IVehicleTypeRepository vehicleTypeRepository;

    public VehicleTypeService(IVehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public List<VehicleTypeViewModel> getVehicleTypes() {
        return this.vehicleTypeRepository
                .findAll()
                .stream()
                .map(vehicleType -> new VehicleTypeViewModel(
                        vehicleType.getDetails(),
                        vehicleType.getDescription(),
                        vehicleType.getId())
                )
                .toList();
    }

    public void addVehicleType(VehicleTypeFormModel formModel) {
        var vehicleType = new VehicleType();
        vehicleType
                .setDescription(formModel.getDescription())
                .setDetails(formModel.getDetails());

        this.vehicleTypeRepository.save(vehicleType);
    }

    public Optional<VehicleTypeViewModel> findById(Long id) {
        return this.vehicleTypeRepository.findById(id)
                .map(entity -> new VehicleTypeViewModel(
                        entity.getDetails(),
                        entity.getDescription(),
                        entity.getId()));
    }

    public boolean editById(Long id, VehicleTypeFormModel model) {
        var entity = this.vehicleTypeRepository.findById(id);
        if (entity.isPresent()) {
            var vehicleType = entity.get();
            vehicleType
                    .setDescription(model.getDescription())
                    .setDetails(model.getDetails());

            this.vehicleTypeRepository.save(vehicleType);

            return true;
        }

        return false;
    }

    public boolean deleteById(Long id) {
        var entityOpt = this.vehicleTypeRepository.findById(id);

        if (entityOpt.isPresent()) {
            this.vehicleTypeRepository.delete(entityOpt.get());

            return true;
        }

        return false;
    }
}
