package com.mll.data.testing.upgrade.service;

import com.mll.data.testing.upgrade.entity.NeedMoney;

import java.util.List;

public interface NeedMoneyService {
    void saveNeedMoney(NeedMoney needMoney);

    List<NeedMoney> findAll();

    NeedMoney findNeedMoneyByUpgrade(Integer upgrade);
}
