package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.states.AddStateFormModel;
import com.example.fleetApp.dto.states.StateModel;
import com.example.fleetApp.models.State;
import com.example.fleetApp.repositories.IStateRepository;
import com.example.fleetApp.services.interfaces.IStateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService implements IStateService {
    private final IStateRepository stateRepository;

    public StateService(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<StateModel> getStates() {
        return this.stateRepository
                .findAll()
                .stream()
                .map(state -> new StateModel(
                        state.getId(),
                        state.getName(),
                        state.getCapital(),
                        state.getCode()
                ))
                .toList();
    }

    public void addState(AddStateFormModel state) {
        var newState = new State()
                .setCapital(state.getCapital())
                .setCode(state.getCode())
                .setName(state.getName())
                .setCountryId(state.getCountryId());

        this.stateRepository.save(newState);
    }
}
