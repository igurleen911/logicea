package com.logicea.cards.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logicea.cards.entity.Card;

import jakarta.transaction.Transactional;

public interface CardRepository extends JpaRepository<Card,Long>{

	@Transactional
	void deleteByCardName(String cardName);

    @Transactional
    List<Card> findByCardNameOrCardColorOrCardStatusOrCreatedDate(String cardName,String cardColor,String cardStatus,Date createdDate);
}
