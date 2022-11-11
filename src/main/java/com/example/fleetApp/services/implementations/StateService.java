package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.states.AddStateFormModel;
import com.example.fleetApp.dto.states.StateModel;
import com.example.fleetApp.models.State;
import com.example.fleetApp.repositories.IStateRepository;
import com.example.fleetApp.services.interfaces.IStateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                        state.getCode(),
                        state.getCountryId()
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

    public Optional<StateModel> findById(Long id) {
        return this.stateRepository.findById(id)
                .map(entity -> new StateModel(
                        entity.getId(),
                        entity.getName(),
                        entity.getCapital(),
                        entity.getCode(),
                        entity.getCountryId()));
    }

    public boolean editById(Long id, StateModel model) {
        var entity = this.stateRepository.findById(id);
        if (entity.isPresent()) {
            var state = entity.get();
            state.setCapital(model.getCapital())
                    .setCode(model.getCode())
                    .setName(model.getName());

            this.stateRepository.save(state);

            return true;
        }

        return false;
    }

    public boolean deleteById(Long id) {
        var entityOpt = this.stateRepository.findById(id);

        if (entityOpt.isPresent()) {
            this.stateRepository.delete(entityOpt.get());

            return true;
        }

        return false;
    }
}
