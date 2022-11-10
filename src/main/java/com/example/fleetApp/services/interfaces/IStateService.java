package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.states.AddStateFormModel;
import com.example.fleetApp.dto.states.StateModel;

import java.util.List;

public interface IStateService {
    List<StateModel> getStates();

    void addState(AddStateFormModel state);
}
