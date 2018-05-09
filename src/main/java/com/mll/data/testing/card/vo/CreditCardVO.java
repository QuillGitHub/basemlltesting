package com.mll.data.testing.card.vo;

public class CreditCardVO {

    //信用卡卡号
    private String cardNumber;

    //信用卡有效期
    private String validityDate;

    //cvn
    private String cvn;

    //所属银行
    private String affiliatedBank;

    //预留手机号
    private String reservedPhoneNumber;

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

    public String getAffiliatedBank() {
        return affiliatedBank;
    }

    public void setAffiliatedBank(String affiliatedBank) {
        this.affiliatedBank = affiliatedBank;
    }

    public String getReservedPhoneNumber() {
        return reservedPhoneNumber;
    }

    public void setReservedPhoneNumber(String reservedPhoneNumber) {
        this.reservedPhoneNumber = reservedPhoneNumber;
    }
}
