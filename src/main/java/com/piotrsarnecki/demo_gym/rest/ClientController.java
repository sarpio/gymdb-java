package com.piotrsarnecki.demo_gym.rest;

import com.piotrsarnecki.demo_gym.rest.dto.ClientDTO;
import com.piotrsarnecki.demo_gym.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client")
    public List<ClientDTO> findClients() {
        return clientService.findClients();
    }

    @PostMapping("/client")
    public ClientDTO addClient(@Valid @RequestBody ClientDTO clientDTO) {
        return clientService.addClient(clientDTO);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity responseEntity(@PathVariable(name = "id") Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}