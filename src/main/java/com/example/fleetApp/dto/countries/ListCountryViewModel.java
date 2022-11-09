package com.example.fleetApp.dto.countries;

public class ListCountryViewModel {
    private Long id;
    private String code;
    private String capital;
    private String description;
    private String nationality;
    private String continent;

    public Long getId() {
        return id;
    }

    public ListCountryViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ListCountryViewModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCapital() {
        return capital;
    }

    public ListCountryViewModel setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ListCountryViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public ListCountryViewModel setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public String getContinent() {
        return continent;
    }

    public ListCountryViewModel setContinent(String continent) {
        this.continent = continent;
        return this;
    }
}
