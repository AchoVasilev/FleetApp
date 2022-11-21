package com.example.fleetApp.controllers.api;

import com.example.fleetApp.dto.clients.ClientFormModel;
import com.example.fleetApp.dto.clients.ClientViewModel;
import com.example.fleetApp.services.interfaces.IClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientsApiController {
    private final IClientService clientService;

    public ClientsApiController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ClientViewModel> findById(@PathVariable("id") Long id) {
        var statesOpt = this.clientService.findById(id);

        return statesOpt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping(value = "/editById/{id}", consumes = "application/json")
    public ResponseEntity<String> editById(@PathVariable("id") Long id, @RequestBody ClientFormModel model) {
        var edited = this.clientService.edit(id, model);

        if (edited) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        var isDeleted = this.clientService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}
