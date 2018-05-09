package com.mll.data.testing.user.service;

import com.mll.data.testing.user.entity.PromotionNumber;

import java.util.Map;

public interface PromotionNumberService {
    void savePromotionNumber(PromotionNumber promotionNumber);

    PromotionNumber findPromotionNumberByUserId(String UserId);

    void updatePromotionNumber(Map<String, Object> filters);
}
