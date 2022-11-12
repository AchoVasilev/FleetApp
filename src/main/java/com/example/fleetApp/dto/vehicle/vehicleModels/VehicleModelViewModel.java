package com.example.fleetApp.dto.vehicle.vehicleModels;

import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeFormModel;

public class VehicleModelViewModel extends VehicleTypeFormModel {
    private Long id;
    public VehicleModelViewModel(String details, String description, Long id) {
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
