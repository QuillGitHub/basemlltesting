package com.mll.data.testing.auditing.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_examine_photo")
public class ExaminePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user_id")
    private String userId;

    private Integer status;

    @Column(name = "card_front")
    private String cardFront;

    @Column(name = "card_back")
    private String cardBack;

    @Column(name = "credit_card_front")
    private String creditCardFront;

    @Column(name = "handheld_identity_card")
    private String handheldIdentityCard;

    @Column(name = "deposit_card_front")
    private String depositCardFront;

    @Column(name = "face_recognition")
    private String faceRecognition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCardFront() {
        return cardFront;
    }

    public void setCardFront(String cardFront) {
        this.cardFront = cardFront;
    }

    public String getCardBack() {
        return cardBack;
    }

    public void setCardBack(String cardBack) {
        this.cardBack = cardBack;
    }

    public String getCreditCardFront() {
        return creditCardFront;
    }

    public void setCreditCardFront(String creditCardFront) {
        this.creditCardFront = creditCardFront;
    }

    public String getHandheldIdentityCard() {
        return handheldIdentityCard;
    }

    public void setHandheldIdentityCard(String handheldIdentityCard) {
        this.handheldIdentityCard = handheldIdentityCard;
    }

    public String getDepositCardFront() {
        return depositCardFront;
    }

    public void setDepositCardFront(String depositCardFront) {
        this.depositCardFront = depositCardFront;
    }

    public String getFaceRecognition() {
        return faceRecognition;
    }

    public void setFaceRecognition(String faceRecognition) {
        this.faceRecognition = faceRecognition;
    }
}
