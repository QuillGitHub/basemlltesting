package com.mll.data.testing.card.service;

import com.mll.data.testing.card.entity.CreditCard;

import java.util.List;
import java.util.Map;

public interface CreditCardService {
    void saveCreditCard(CreditCard creditCard);

    CreditCard findCreditCardByByCardNumber(String cardNumber);

    List<CreditCard> findCreditCardByUserIdList(String userId);

    void updateCreditCard(Map<String, Object> filters);

    void deleteCreditCardByCardNumber(String cardNumber);
}
