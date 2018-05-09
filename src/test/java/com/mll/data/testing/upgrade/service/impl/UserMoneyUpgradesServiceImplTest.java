package com.mll.data.testing.upgrade.service.impl;

import com.mll.data.testing.upgrade.entity.UserMoneyUpgrades;
import com.mll.data.testing.upgrade.service.UserMoneyUpgradesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMoneyUpgradesServiceImplTest {

    @Autowired
    private UserMoneyUpgradesService userMoneyUpgradesService;

    @Test
    public void findUserMoneyUpgradesByUserIdMoney() throws Exception {
        String user = "62cffa284f7611e8929bc85b76076a87";
        UserMoneyUpgrades userMoneyUpgrades = userMoneyUpgradesService.findUserMoneyUpgradesByUserIdMoney(user,new BigDecimal(9.9));
    }

}