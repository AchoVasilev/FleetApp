package com.example.fleetApp.services.implementations;

import com.example.fleetApp.dto.clients.ClientFormModel;
import com.example.fleetApp.dto.clients.ClientViewModel;
import com.example.fleetApp.models.Client;
import com.example.fleetApp.repositories.IClientRepository;
import com.example.fleetApp.services.interfaces.IClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    private final IClientRepository clientRepository;

    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientViewModel> getAll() {
        return this.clientRepository.findAll()
                .stream()
                .map(this::map).toList();
    }

    public void add(ClientFormModel clientFormModel) {
        var entity = new Client()
                .setAddress(clientFormModel.getAddress())
                .setCity(clientFormModel.getCity())
                .setDetails(clientFormModel.getDetails())
                .setEmail(clientFormModel.getEmail())
                .setMobile(clientFormModel.getMobile())
                .setPhone(clientFormModel.getPhone())
                .setCountryId(clientFormModel.getCountryId())
                .setStateId(clientFormModel.getStateId())
                .setName(clientFormModel.getName())
                .setWebsite(clientFormModel.getWebsite());

        this.clientRepository.save(entity);
    }

    public boolean edit(Long id, ClientFormModel model) {
        var entity = this.clientRepository.findById(id);
        if (entity.isPresent()) {
            var client = entity.get();
            client.setAddress(model.getAddress())
                    .setCity(model.getCity())
                    .setDetails(model.getDetails())
                    .setEmail(model.getEmail())
                    .setMobile(model.getMobile())
                    .setPhone(model.getPhone())
                    .setCountryId(model.getCountryId())
                    .setStateId(model.getStateId())
                    .setName(model.getName())
                    .setWebsite(model.getWebsite());

            this.clientRepository.save(client);

            return true;
        }

        return false;
    }

    public Optional<ClientViewModel> findById(Long clientId) {
        return this.clientRepository.findById(clientId)
                .map(this::map);
    }

    public boolean delete(Long clientId) {
        var entityOpt = this.clientRepository.findById(clientId);

        if (entityOpt.isPresent()) {
            this.clientRepository.delete(entityOpt.get());

            return true;
        }

        return false;
    }

    private ClientViewModel map(Client clientEntity) {
        return new ClientViewModel(
                clientEntity.getId(),
                clientEntity.getName(),
                clientEntity.getAddress(),
                clientEntity.getCity(),
                clientEntity.getPhone(),
                clientEntity.getMobile(),
                clientEntity.getWebsite(),
                clientEntity.getEmail(),
                clientEntity.getDetails(),
                clientEntity.getCountryId(),
                clientEntity.getStateId()
        );
    }
}
