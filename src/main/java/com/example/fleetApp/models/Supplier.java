package com.example.fleetApp.models;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private String phone;
    private String mobile;
    private String website;
    private String email;
    private String details;

    private Long countryId;
    @ManyToOne
    private Country country;

    private Long stateId;
    @ManyToOne
    private State state;

    public Long getId() {
        return id;
    }

    public Supplier setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Supplier setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Supplier setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Supplier setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Supplier setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Supplier setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public Supplier setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Supplier setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public Supplier setDetails(String details) {
        this.details = details;
        return this;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Supplier setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Supplier setCountry(Country country) {
        this.country = country;
        return this;
    }

    public Long getStateId() {
        return stateId;
    }

    public Supplier setStateId(Long stateId) {
        this.stateId = stateId;
        return this;
    }

    public State getState() {
        return state;
    }

    public Supplier setState(State state) {
        this.state = state;
        return this;
    }
}
