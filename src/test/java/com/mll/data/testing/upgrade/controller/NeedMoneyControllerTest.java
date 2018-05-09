package com.mll.data.testing.upgrade.controller;

import com.mll.data.testing.share.StatusSummary;
import com.mll.data.testing.upgrade.entity.NeedMoney;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NeedMoneyControllerTest {

    @Autowired
    private NeedMoneyController needMoneyController;

    @Test
    public void saveNeedMoney() throws Exception {

        //铜牌升银牌
        NeedMoney needMoneyTSY = new NeedMoney();
        needMoneyTSY.setGrade("铜牌升银牌");
        needMoneyTSY.setAbbreviation("BUS");
        needMoneyTSY.setMoney(new BigDecimal(9.9));
        needMoneyTSY.setUpgrade(StatusSummary.UpgradeTo.BRONZEUPGRADESILVER);
        needMoneyController.saveNeedMoney(needMoneyTSY);

        //银牌升金牌
        NeedMoney needMoneyYSJ = new NeedMoney();
        needMoneyYSJ.setGrade("银牌升金牌");
        needMoneyYSJ.setAbbreviation("SUG");
        needMoneyYSJ.setMoney(new BigDecimal(90));
        needMoneyYSJ.setUpgrade(StatusSummary.UpgradeTo.SILVERUPGRADEGOLD);
        needMoneyController.saveNeedMoney(needMoneyYSJ);

        //铜牌升金牌
        NeedMoney needMoneyTSJ = new NeedMoney();
        needMoneyTSJ.setGrade("铜牌升金牌");
        needMoneyTSJ.setAbbreviation("BUG");
        needMoneyTSJ.setMoney(new BigDecimal(99));
        needMoneyTSJ.setUpgrade(StatusSummary.UpgradeTo.BRONZEUPGRADEGOLD);
        needMoneyController.saveNeedMoney(needMoneyTSJ);



    }

}