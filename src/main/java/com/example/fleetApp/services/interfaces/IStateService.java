package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.states.AddStateFormModel;
import com.example.fleetApp.dto.states.StateModel;

import java.util.List;
import java.util.Optional;

public interface IStateService {
    List<StateModel> getStates();

    void addState(AddStateFormModel state);

    Optional<StateModel> findById(Long id);

    boolean editById(Long id, StateModel model);

    boolean deleteById(Long id);
}
