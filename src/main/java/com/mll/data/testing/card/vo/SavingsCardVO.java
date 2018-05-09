package com.mll.data.testing.card.vo;

public class SavingsCardVO {

    //银行卡号
    private String cardNumber;

    //开户行省市区
    private String cardAddress;

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

    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress;
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
