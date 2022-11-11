package com.example.fleetApp.dto.vehicle.vehicleMovements;

import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeFormModel;

public class VehicleMovementViewModel extends VehicleTypeFormModel {
    private Long id;
    public VehicleMovementViewModel(String details, String description, Long id) {
        super(details, description);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
