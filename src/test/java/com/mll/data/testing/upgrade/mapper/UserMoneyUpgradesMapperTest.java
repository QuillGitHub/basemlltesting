package com.mll.data.testing.upgrade.mapper;

import com.mll.data.testing.upgrade.entity.UserMoneyUpgrades;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMoneyUpgradesMapperTest {

    @Autowired
    private UserMoneyUpgradesMapper userMoneyUpgradesMapper;

    @Test
    public void findUserMoneyUpgradesByUserIdMoney() throws Exception {
        String user = "62cffa284f7611e8929bc85b76076a87";
        double bigDecimal = 9.9;
        UserMoneyUpgrades userMoneyUpgrades = userMoneyUpgradesMapper.findUserMoneyUpgradesByUserIdMoney(user,new BigDecimal(9.90));
    }

}