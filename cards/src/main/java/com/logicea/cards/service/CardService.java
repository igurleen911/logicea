package com.logicea.cards.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.logicea.cards.entity.Card;

public interface CardService {

	List<Card> findAll();

	Card save(Card newCard);

	Optional<Card> findById(Long cardId);

	List<Card> findByCardNameOrCardColorOrCardStatusOrCreatedDate(String cardName, String cardColor, String cardStatus,
			Date createdDate);

	void deleteByCardName(String cardName);
    
}
