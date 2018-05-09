package com.mll.data.testing.upgrade.service;

import com.mll.data.testing.upgrade.entity.UserPeopleUpgrades;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 20:21
 **/

public interface UserPeopleUpgradesService {
    void saveUserPeopleUpgrades(UserPeopleUpgrades userPeopleUpgrades);

    UserPeopleUpgrades findUserPeopleUpgradesByUserId(String userId);

    UserPeopleUpgrades updateUserPeopleUpgradesByUserId(String userId, Integer recommendedNumber);
}
