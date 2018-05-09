package com.mll.data.testing.upgrade.controller;

import com.mll.data.testing.upgrade.entity.UserMoneyUpgrades;
import com.mll.data.testing.upgrade.service.UserMoneyUpgradesService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 19:06
 **/

@RestController
@RequestMapping("/UserMoneyUpgrades")
public class UserMoneyUpgradesController {

    @Autowired
    private UserMoneyUpgradesService userMoneyUpgradesService;

    @PostMapping("/save")
    public String saveUserMoneyUpgrades(UserMoneyUpgrades userMoneyUpgrades){
        userMoneyUpgradesService.saveUserMoneyUpgrades(userMoneyUpgrades);
        return JSONUtil.assemble(Result.SUCCESS,"保存金额升级记录");
    }

    @PostMapping("/findUserMoneyUpgradesByUserIdMoney")
    public String findUserMoneyUpgradesByUserIdMoney(String userId, BigDecimal money){
        userMoneyUpgradesService.findUserMoneyUpgradesByUserIdMoney(userId,money);
        return JSONUtil.assemble(Result.SUCCESS,"查询到该次升级记录");
    }

}
