package com.mll.data.testing.upgrade.service;

import com.mll.data.testing.upgrade.entity.UserUpgradeMode;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 18:05
 **/

public interface UserUpgradeModeService  {
    void saveUserUpgradeMode(UserUpgradeMode userUpgradeMode);

    UserUpgradeMode findUserUpgradeModeByUserId(String userId);

    void updateUserUpgradeMode(String userId, Integer type);
}
