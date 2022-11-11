package com.example.fleetApp.dto.vehicle.vehicleMovements;

public class VehicleMovementFormModel {
    private String details;
    private String description;

    public VehicleMovementFormModel(String details, String description) {
        this.details = details;
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
