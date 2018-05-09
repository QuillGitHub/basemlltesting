package com.mll.data.testing.card.service;

import com.mll.data.testing.card.entity.UserBankInfo;

import java.util.List;
import java.util.Map;

public interface UserBankInfoService {
    void saveUserBankInfo(UserBankInfo userBankInfo);

    UserBankInfo findUserBankInfoByCardId(String cardId);

    List<UserBankInfo> findUserBankInfoByUserId(String userId);

    UserBankInfo findUserBankInfoByCardIdAndCardType(Map<String, Object> filter);

    UserBankInfo findUserBankInfoById(String id);

    List<UserBankInfo> findUserBankInfoByUserIdAndCardTypeAndStatusList(Map<String, Object> filters);

    void deleteUserBankInfoById(String id);
}
