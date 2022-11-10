package com.example.fleetApp.dto.locations;

public class LocationViewModel {
    private Long id;
    private String city;
    private String address;
    private String description;
    private String details;

    public Long getId() {
        return id;
    }

    public LocationViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public LocationViewModel setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public LocationViewModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LocationViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public LocationViewModel setDetails(String details) {
        this.details = details;
        return this;
    }
}
