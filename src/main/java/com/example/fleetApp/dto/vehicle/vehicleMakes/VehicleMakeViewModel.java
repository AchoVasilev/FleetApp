package com.example.fleetApp.dto.vehicle.vehicleMakes;

import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeFormModel;

public class VehicleMakeViewModel extends VehicleTypeFormModel {
    private Long id;
    public VehicleMakeViewModel(String details, String description, Long id) {
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
