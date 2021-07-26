package com.piotrsarnecki.demo_gym.services;

import com.piotrsarnecki.demo_gym.entities.CardTypeEntity;
import com.piotrsarnecki.demo_gym.entities.GymEntity;
import com.piotrsarnecki.demo_gym.repositories.CardTypeRepository;
import com.piotrsarnecki.demo_gym.repositories.GymRepository;
import com.piotrsarnecki.demo_gym.rest.dto.CardTypeDTO;
import com.piotrsarnecki.demo_gym.util.EntityDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardTypeService {
    private final CardTypeRepository cardTypeRepository;
    private final GymRepository gymRepository;

    public CardTypeService(CardTypeRepository cardTypeRepository, GymRepository gymRepository) {
        this.cardTypeRepository = cardTypeRepository;
        this.gymRepository = gymRepository;
    }


    public List<CardTypeDTO> findCardTypes() {
        return cardTypeRepository.findAll().stream()
                .map(EntityDtoMapper::map)
                .collect(Collectors.toList());
    }

    public CardTypeDTO addCardType(CardTypeDTO cardTypeDTO) {
        CardTypeEntity cardTypeEntity = EntityDtoMapper.map(cardTypeDTO);
        CardTypeEntity save = cardTypeRepository.save(cardTypeEntity);
        return EntityDtoMapper.map(save);
    }

    public void deleteCardType(Long id) {
        cardTypeRepository.deleteById(id);
    }

    public CardTypeDTO addCardTypeToGym(Long cardTypeId, Long gymId) {
        CardTypeEntity cardTypeEntity = cardTypeRepository.findById(cardTypeId).get();
        GymEntity gymEntity = gymRepository.findById(gymId).get();
        cardTypeEntity.getGymEntities().add(gymEntity);
        gymEntity.getCardTypeEntities().add(cardTypeEntity);
        cardTypeRepository.save(cardTypeEntity);
        return EntityDtoMapper.map(cardTypeEntity);
    }
}
