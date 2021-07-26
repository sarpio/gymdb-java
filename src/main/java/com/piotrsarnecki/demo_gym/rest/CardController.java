package com.piotrsarnecki.demo_gym.rest;

import com.piotrsarnecki.demo_gym.rest.dto.CardDTO;
import com.piotrsarnecki.demo_gym.services.CardService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @Operation(description = "delete card by id")
    @DeleteMapping("/card/{id}")
    public ResponseEntity deleteCard(@PathVariable(name = "id") Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.ok().build();
    }

    @Operation(description = "add card to user")
    @PostMapping("/card")
    public CardDTO addCard(@Valid @RequestBody CardDTO cardDTO) {
        return cardService.addCardToUser(cardDTO);
    }
}