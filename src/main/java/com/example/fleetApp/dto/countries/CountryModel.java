package com.example.fleetApp.dto.countries;

public class CountryModel {
    private Long id;
    private String code;
    private String capital;
    private String description;
    private String nationality;
    private String continent;

    public Long getId() {
        return id;
    }

    public CountryModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CountryModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCapital() {
        return capital;
    }

    public CountryModel setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CountryModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public CountryModel setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public String getContinent() {
        return continent;
    }

    public CountryModel setContinent(String continent) {
        this.continent = continent;
        return this;
    }
}
