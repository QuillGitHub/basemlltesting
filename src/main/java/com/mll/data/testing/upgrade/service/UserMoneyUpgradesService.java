package com.mll.data.testing.upgrade.service;

import com.mll.data.testing.upgrade.entity.UserMoneyUpgrades;

import java.math.BigDecimal;

public interface UserMoneyUpgradesService {
    void saveUserMoneyUpgrades(UserMoneyUpgrades userMoneyUpgrades);

    UserMoneyUpgrades findUserMoneyUpgradesByUserIdMoney(String userId, BigDecimal money);
}
