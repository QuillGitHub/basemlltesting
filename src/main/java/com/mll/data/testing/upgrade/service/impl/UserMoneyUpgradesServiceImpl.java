package com.mll.data.testing.upgrade.service.impl;

import com.mll.data.testing.upgrade.entity.UserMoneyUpgrades;
import com.mll.data.testing.upgrade.mapper.UserMoneyUpgradesMapper;
import com.mll.data.testing.upgrade.service.UserMoneyUpgradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 19:05
 **/

@Service
@Transactional
public class UserMoneyUpgradesServiceImpl implements UserMoneyUpgradesService {

    @Autowired
    private UserMoneyUpgradesMapper userMoneyUpgradesMapper;

    /**
     * 保存 保存金额升级记录
     * @param userMoneyUpgrades
     */
    @Override
    public void saveUserMoneyUpgrades(UserMoneyUpgrades userMoneyUpgrades){
        userMoneyUpgrades.setPaymentTime(new Date());
        userMoneyUpgradesMapper.insert(userMoneyUpgrades);
    }

    /**
     * 查询 根据用户id 与升级金额 查询
     * @param userId
     * @param money
     * @return
     */
    @Override
    public UserMoneyUpgrades findUserMoneyUpgradesByUserIdMoney(String userId, BigDecimal money){
        return userMoneyUpgradesMapper.findUserMoneyUpgradesByUserIdMoney(userId,money);
    }

}
