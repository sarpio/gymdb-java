package com.piotrsarnecki.demo_gym.util;

import com.piotrsarnecki.demo_gym.entities.*;
import com.piotrsarnecki.demo_gym.rest.dto.*;
import org.springframework.beans.BeanUtils;

import java.util.stream.Collectors;

public class EntityDtoMapper {
    public static CardDTO map(CardEntity cardEntity) {
        CardDTO cardDTO = new CardDTO();
        BeanUtils.copyProperties(cardEntity, cardDTO);
        if(cardEntity.getCardTypeEntity() != null) {
            cardDTO.setCardType(map(cardEntity.getCardTypeEntity()));
        }
        return cardDTO;
    }

    public static CardEntity map(CardDTO cardDTO) {
        CardEntity cardEntity = new CardEntity();
        BeanUtils.copyProperties(cardDTO, cardEntity);
        return cardEntity;
    }

    public static CardTypeDTO map(CardTypeEntity cardTypeEntity) {
        CardTypeDTO cardTypeDTO = new CardTypeDTO();
        BeanUtils.copyProperties(cardTypeEntity, cardTypeDTO);
        if(cardTypeEntity.getGymEntities() != null) {
            cardTypeDTO.setGyms(cardTypeEntity.getGymEntities().stream()
                    .map(EntityDtoMapper::map)
                    .collect(Collectors.toSet()));
        }
        return cardTypeDTO;
    }

    public static CardTypeEntity map(CardTypeDTO cardTypeDTO) {
        CardTypeEntity cardTypeEntity = new CardTypeEntity();
        BeanUtils.copyProperties(cardTypeDTO, cardTypeEntity);
        return cardTypeEntity;
    }

    public static ClientDTO map(ClientEntity clientEntity) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(clientEntity, clientDTO);
        if(clientDTO.getCards() != null) {
            clientDTO.setCards(clientEntity.getCardEntitySet().stream()
                    .map(EntityDtoMapper::map)
                    .collect(Collectors.toSet()));
        }
        return clientDTO;
    }

    public static ClientEntity map(ClientDTO clientDTO) {
        ClientEntity clientEntity = new ClientEntity();
        BeanUtils.copyProperties(clientDTO, clientEntity);
        return clientEntity;
    }

    public static EmployeeDTO map(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employeeEntity, employeeDTO);
        if(employeeEntity.getGymEntity() != null) {
            employeeDTO.setGym(EntityDtoMapper.map(employeeEntity.getGymEntity()));
        }
        return employeeDTO;
    }

    public static EmployeeEntity map(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO, employeeEntity);
        return employeeEntity;
    }

    public static GymDTO map(GymEntity gymEntity) {
        GymDTO gymDTO = new GymDTO();
        BeanUtils.copyProperties(gymEntity, gymDTO);
        return gymDTO;
    }

    public static GymEntity map(GymDTO gymDTO) {
        GymEntity gymEntity = new GymEntity();
        BeanUtils.copyProperties(gymDTO, gymEntity);
        return gymEntity;
    }
}
