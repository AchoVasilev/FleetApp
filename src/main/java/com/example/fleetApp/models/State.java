package com.example.fleetApp.models;

import javax.persistence.*;

@Entity
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String capital;
    private String code;

    private Long countryId;
    @ManyToOne
    @JoinColumn(name="countryId", insertable=false, updatable=false)
    private Country country;

    private String details;

    public Long getId() {
        return id;
    }

    public State setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public State setName(String name) {
        this.name = name;
        return this;
    }

    public String getCapital() {
        return capital;
    }

    public State setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public String getCode() {
        return code;
    }

    public State setCode(String code) {
        this.code = code;
        return this;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State setCountryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public State setCountry(Country country) {
        this.country = country;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public State setDetails(String details) {
        this.details = details;
        return this;
    }
}
