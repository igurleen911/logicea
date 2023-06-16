package com.logicea.cards.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logicea.cards.entity.Card;
import com.logicea.cards.repository.CardRepository;
import com.logicea.cards.service.CardService;


@RestController
public class CardController {

    private final CardRepository cardRepo;
    
    @Autowired
    CardService cardService;

    CardController(CardRepository cardRepo){
        this.cardRepo = cardRepo;
    }

    @GetMapping("/cards")
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
    List<Card> all(){
        return cardService.findAll();
    }

    @PostMapping("/newCard")
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
    Card newCard(@RequestBody Card newCard){
        return cardService.save(newCard);
    }

    @GetMapping("/card/{cardId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    Optional<Card> one(@PathVariable Long cardId){
        return cardService.findById(cardId);
    }
    
    @GetMapping("/getCard")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseBody
    List<Card> getCard(@RequestParam(required = false) String cardName,@RequestParam(required = false) String cardColor,
    			@RequestParam(required = false) String cardStatus,@RequestParam(required = false) Date createdDate){
        return cardService.findByCardNameOrCardColorOrCardStatusOrCreatedDate(cardName, cardColor, cardStatus, createdDate);
    }

    @DeleteMapping("/card/{cardName}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    void deleteCard(@PathVariable String cardName){
    	cardService.deleteByCardName(cardName);
    }

    @PutMapping(value="path/{id}")
    public Card putMethodName(@PathVariable Long id, @RequestBody Card newCard) {
       return cardRepo.findById(id)
       .map(card -> {
        card.setCardColor(newCard.getCardColor());
        card.setCardStatus(newCard.getCardStatus());  
        card.setCardName(newCard.getCardName());
        card.setDescription(newCard.getDescription());
        return cardService.save(card);  
    })
    .orElseGet(() -> {
        newCard.setCardId(id);
        return cardService.save(newCard);
    });
    }
    
}
