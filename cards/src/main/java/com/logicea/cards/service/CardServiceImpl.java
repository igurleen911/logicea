package com.logicea.cards.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logicea.cards.entity.Card;
import com.logicea.cards.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	CardRepository cardRepo;
	
	@Override
	public List<Card> findAll() {
		// TODO Auto-generated method stub
		return cardRepo.findAll();
	}

	@Override
	public Card save(Card newCard) {
		// TODO Auto-generated method stub
		return cardRepo.save(newCard);
	}

	@Override
	public Optional<Card> findById(Long cardId) {
		// TODO Auto-generated method stub
		return cardRepo.findById(cardId);
	}

	@Override
	public List<Card> findByCardNameOrCardColorOrCardStatusOrCreatedDate(String cardName, String cardColor,
			String cardStatus, Date createdDate) {
		// TODO Auto-generated method stub
		return cardRepo.findByCardNameOrCardColorOrCardStatusOrCreatedDate(cardName, cardColor, cardStatus, createdDate);
	}

	@Override
	public void deleteByCardName(String cardName) {
		// TODO Auto-generated method stub
		cardRepo.deleteByCardName(cardName);
	}
    
}
