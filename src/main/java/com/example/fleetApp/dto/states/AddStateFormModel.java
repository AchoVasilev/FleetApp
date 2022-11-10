package com.example.fleetApp.dto.states;

public class AddStateFormModel extends BaseState{
    private Long countryId;

    public AddStateFormModel(Long id, String name, String capital, String code, Long countryId) {
        super(id, name, capital, code);
        this.countryId = countryId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
