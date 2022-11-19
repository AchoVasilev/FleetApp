package com.example.fleetApp.services.interfaces;

import com.example.fleetApp.dto.clients.ClientFormModel;
import com.example.fleetApp.dto.clients.ClientViewModel;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    List<ClientViewModel> getAll();

    void add(ClientFormModel clientFormModel);

    Optional<ClientViewModel> findById(Long clientId);

    boolean delete(Long clientId);
}
