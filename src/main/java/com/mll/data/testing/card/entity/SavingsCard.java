package com.mll.data.testing.card.entity;

import javax.persistence.*;

@Table(name = "t_savings_card")
public class SavingsCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "affiliated_bank")
    private String affiliatedBank;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_address")
    private String cardAddress;

    @Column(name = "reserved_phone_number")
    private String reservedPhoneNumber;

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

    public String getAffiliatedBank() {
        return affiliatedBank;
    }

    public void setAffiliatedBank(String affiliatedBank) {
        this.affiliatedBank = affiliatedBank;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress;
    }

    public String getReservedPhoneNumber() {
        return reservedPhoneNumber;
    }

    public void setReservedPhoneNumber(String reservedPhoneNumber) {
        this.reservedPhoneNumber = reservedPhoneNumber;
    }
}
