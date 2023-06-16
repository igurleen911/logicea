package com.logicea.cards.entity;


import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Card")
public class Card {

    @Column
    private @Id @GeneratedValue Long cardId;

    @Column(nullable=false)
    private String cardName;

    @Column
    private String cardStatus = "To Do";

    @Column
    private String cardColor;

    @Column
    private String description;

    @Column
    private Long userId;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdDate;

    public Long getCardId() {
        return this.cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardStatus() {
        return this.cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getCardColor() {
        return this.cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    

}
