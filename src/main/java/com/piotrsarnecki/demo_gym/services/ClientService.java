package com.piotrsarnecki.demo_gym.services;

import com.piotrsarnecki.demo_gym.entities.ClientEntity;
import com.piotrsarnecki.demo_gym.repositories.ClientRepository;
import com.piotrsarnecki.demo_gym.rest.dto.ClientDTO;
import com.piotrsarnecki.demo_gym.util.EntityDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> findClients() {
        return clientRepository.findAll().stream().map(EntityDtoMapper::map).collect(Collectors.toList());
    }

    public ClientDTO addClient(ClientDTO clientDTO) {
        ClientEntity clientEntity = EntityDtoMapper.map(clientDTO);
        ClientEntity save = clientRepository.save(clientEntity);
        return EntityDtoMapper.map(save);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
