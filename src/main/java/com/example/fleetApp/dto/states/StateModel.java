package com.example.fleetApp.dto.states;

public class StateModel extends BaseState{
    private Long countryId;

    public StateModel(Long id, String name, String capital, String code, Long countryId) {
        super(id, name, capital, code);

        this.countryId = countryId;
    }
}
