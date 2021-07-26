package com.piotrsarnecki.demo_gym.services;

import com.piotrsarnecki.demo_gym.entities.GymEntity;
import com.piotrsarnecki.demo_gym.repositories.CardTypeRepository;
import com.piotrsarnecki.demo_gym.repositories.GymRepository;
import com.piotrsarnecki.demo_gym.rest.dto.GymDTO;
import com.piotrsarnecki.demo_gym.util.EntityDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymService {
    private final GymRepository gymRepository;
    private final CardTypeRepository cardTypeRepository;

    public GymService(GymRepository gymRepository, CardTypeRepository cardTypeRepository) {
        this.gymRepository = gymRepository;
        this.cardTypeRepository = cardTypeRepository;
    }

    public List<GymDTO> findGyms() {
        return gymRepository.findAll().stream()
                .map(EntityDtoMapper::map)
                .collect(Collectors.toList());
    }

    public GymDTO addGym(GymDTO gymDTO) {
        GymEntity gymEntity = EntityDtoMapper.map(gymDTO);
        GymEntity save = gymRepository.save(gymEntity);
        return EntityDtoMapper.map(save);
    }

    public void deleteGym(Long id) {
        gymRepository.deleteById(id);
    }
}
