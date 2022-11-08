package com.example.fleetApp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String capital;
    private String description;
    private String nationality;
    private String continent;
    @OneToMany(mappedBy = "country")
    private List<State> states = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Country setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Country setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCapital() {
        return capital;
    }

    public Country setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Country setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public Country setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public String getContinent() {
        return continent;
    }

    public Country setContinent(String continent) {
        this.continent = continent;
        return this;
    }

    public List<State> getStates() {
        return states;
    }

    public Country setStates(List<State> states) {
        this.states = states;
        return this;
    }
}
