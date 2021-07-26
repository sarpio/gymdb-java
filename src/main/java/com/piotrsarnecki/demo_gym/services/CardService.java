package com.piotrsarnecki.demo_gym.services;

import com.piotrsarnecki.demo_gym.entities.CardEntity;
import com.piotrsarnecki.demo_gym.entities.CardTypeEntity;
import com.piotrsarnecki.demo_gym.entities.ClientEntity;
import com.piotrsarnecki.demo_gym.repositories.CardRepository;
import com.piotrsarnecki.demo_gym.repositories.CardTypeRepository;
import com.piotrsarnecki.demo_gym.repositories.ClientRepository;
import com.piotrsarnecki.demo_gym.rest.dto.CardDTO;
import com.piotrsarnecki.demo_gym.util.EntityDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final CardTypeRepository cardTypeRepository;
    private final ClientRepository clientRepository;

    public CardService(CardRepository cardRepository, CardTypeRepository cardTypeRepository, ClientRepository clientRepository) {
        this.cardRepository = cardRepository;
        this.cardTypeRepository = cardTypeRepository;
        this.clientRepository = clientRepository;
    }

    public CardDTO addCardToUser(CardDTO cardDTO) {
        CardTypeEntity cardTypeEntity = cardTypeRepository.findById(cardDTO.getCardType().getId()).get();
        ClientEntity clientEntity = clientRepository.findById(cardDTO.getClientId()).get();
        CardEntity card = EntityDtoMapper.map(cardDTO);
        card.setValidFrom(cardDTO.getValidFrom());
        card.setValidTo(cardDTO.getValidTo());
        card.setCardTypeEntity(cardTypeEntity);
        card.setClientEntity(clientEntity);
        clientEntity.getCardEntitySet().add(card);
        cardTypeEntity.getCardEntitySet().add(card);
        CardEntity save = cardRepository.save(card);
        return EntityDtoMapper.map(save);
    }

    public void deleteCard(Long cardId) {
        cardRepository.deleteById(cardId);
    }
}
