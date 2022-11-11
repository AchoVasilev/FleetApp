package com.example.fleetApp.dto.vehicle.vehicleTypes;

public class VehicleTypeViewModel extends VehicleTypeFormModel{
    private Long id;
    public VehicleTypeViewModel(String details, String description, Long id) {
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
