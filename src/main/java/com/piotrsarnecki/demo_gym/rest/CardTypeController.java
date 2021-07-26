package com.piotrsarnecki.demo_gym.rest;

import com.piotrsarnecki.demo_gym.rest.dto.CardTypeDTO;
import com.piotrsarnecki.demo_gym.services.CardTypeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CardTypeController {

    private final CardTypeService cardTypeService;

    public CardTypeController(CardTypeService cardTypeService) {
        this.cardTypeService = cardTypeService;
    }

    @GetMapping("/cardTypes")
    public List<CardTypeDTO> getCardTypes() {
        return cardTypeService.findCardTypes();
    }

    @PostMapping("/cardType")
    public CardTypeDTO addCardType(@Valid @RequestBody CardTypeDTO cardTypeDTO) {
        return cardTypeService.addCardType(cardTypeDTO);
    }

    @Operation(description = "add card type to be valid in gym")
    @PostMapping("/cardType/{cardTypeId}/gym/{gymId}")
    public CardTypeDTO addCardTypeToGym(@PathVariable(name = "cardTypeId") Long cardTypeId,
                                        @PathVariable(name = "gymId") Long gymId) {
        return cardTypeService.addCardTypeToGym(cardTypeId, gymId);
    }

    @DeleteMapping("/cardType/{id}")
    public ResponseEntity deleteCardType(@PathVariable(name = "id") Long id) {
        cardTypeService.deleteCardType(id);
        return ResponseEntity.ok().build();
    }
}
