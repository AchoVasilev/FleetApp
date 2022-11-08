package com.example.fleetApp.models;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location extends CommonObject{
    private String city;
    private String address;

    private Long countryId;
    @ManyToOne
    private Country country;

    private Long stateId;
    @ManyToOne
    private State state;

    public String getCity() {
        return city;
    }

    public Location setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Location setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Location setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Location setCountry(Country country) {
        this.country = country;
        return this;
    }

    public Long getStateId() {
        return stateId;
    }

    public Location setStateId(Long stateId) {
        this.stateId = stateId;
        return this;
    }

    public State getState() {
        return state;
    }

    public Location setState(State state) {
        this.state = state;
        return this;
    }
}
