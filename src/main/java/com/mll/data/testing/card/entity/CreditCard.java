package com.mll.data.testing.card.entity;

import javax.persistence.*;

@Table(name = "t_credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "affiliated_bank")
    private String affiliatedBank;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "validity_date")
    private String validityDate;

    private String cvn;

    @Column(name = "reserved_phone_number")
    private String reservedPhoneNumber;

    @Column(name = "bank_card_quota")
    private Integer bankCardQuota;

    @Column(name = "statement_date")
    private String statementDate;

    @Column(name = "repayment_date")
    private String repaymentDate;

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

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public String getCvn() {
        return cvn;
    }

    public void setCvn(String cvn) {
        this.cvn = cvn;
    }

    public String getReservedPhoneNumber() {
        return reservedPhoneNumber;
    }

    public void setReservedPhoneNumber(String reservedPhoneNumber) {
        this.reservedPhoneNumber = reservedPhoneNumber;
    }

    public Integer getBankCardQuota() {
        return bankCardQuota;
    }

    public void setBankCardQuota(Integer bankCardQuota) {
        this.bankCardQuota = bankCardQuota;
    }

    public String getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate;
    }

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }
}
