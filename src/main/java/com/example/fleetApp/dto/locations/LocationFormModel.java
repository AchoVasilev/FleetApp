package com.example.fleetApp.dto.locations;

public class LocationFormModel {
    private String city;
    private String address;
    private Long countryId;
    private Long stateId;
    private String description;
    private String details;

    public String getCity() {
        return city;
    }

    public LocationFormModel setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public LocationFormModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getCountryId() {
        return countryId;
    }

    public LocationFormModel setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public Long getStateId() {
        return stateId;
    }

    public LocationFormModel setStateId(Long stateId) {
        this.stateId = stateId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LocationFormModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public LocationFormModel setDetails(String details) {
        this.details = details;
        return this;
    }
}
