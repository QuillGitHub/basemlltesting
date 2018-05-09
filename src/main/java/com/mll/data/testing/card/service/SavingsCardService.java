package com.mll.data.testing.card.service;

import com.mll.data.testing.card.entity.SavingsCard;

import java.util.List;

public interface SavingsCardService {
    void saveSavingsCard(SavingsCard savingsCard);

    SavingsCard findSavingsCardByCardNumber(String cardNumber);

    List<SavingsCard> findSavingsCardByUserIdList(String userId);

    void deleteSavingsCardByCardNumber(String cardNumber);
}
