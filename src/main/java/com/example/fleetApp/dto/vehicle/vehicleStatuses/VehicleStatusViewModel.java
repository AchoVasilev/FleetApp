package com.example.fleetApp.dto.vehicle.vehicleStatuses;

import com.example.fleetApp.dto.vehicle.vehicleTypes.VehicleTypeFormModel;

public class VehicleStatusViewModel extends VehicleTypeFormModel {
    private Long id;
    public VehicleStatusViewModel(String details, String description, Long id) {
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
