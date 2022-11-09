package com.example.fleetApp.dto.countries;

public class AddCountryFormModel {
    private String description;
    private String capital;
    private String code;
    private String continent;
    private String nationality;

    public String getDescription() {
        return description;
    }

    public AddCountryFormModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCapital() {
        return capital;
    }

    public AddCountryFormModel setCapital(String capital) {
        this.capital = capital;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AddCountryFormModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getContinent() {
        return continent;
    }

    public AddCountryFormModel setContinent(String continent) {
        this.continent = continent;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public AddCountryFormModel setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }
}
