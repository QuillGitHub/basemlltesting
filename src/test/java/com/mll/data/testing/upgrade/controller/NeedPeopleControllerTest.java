package com.mll.data.testing.upgrade.controller;

import com.mll.data.testing.share.StatusSummary;
import com.mll.data.testing.upgrade.entity.NeedPeople;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NeedPeopleControllerTest {

    @Autowired
    private NeedPeopleController needPeopleController;

    @Test
    public void saveNeedPeople() throws Exception {

        //铜牌升级银牌
        NeedPeople needPeopleTSY = new NeedPeople();
        needPeopleTSY.setGrade("铜牌升银牌");
        needPeopleTSY.setAbbreviation("BUS");
        needPeopleTSY.setPeople(3);
        needPeopleTSY.setUpgrade(StatusSummary.UpgradeTo.BRONZEUPGRADESILVER);
        needPeopleController.saveNeedPeople(needPeopleTSY);

        //银牌升级金牌
        NeedPeople needPeopleYSJ = new NeedPeople();
        needPeopleYSJ.setGrade("银牌升金牌");
        needPeopleYSJ.setAbbreviation("SUG");
        needPeopleYSJ.setPeople(6);
        needPeopleYSJ.setUpgrade(StatusSummary.UpgradeTo.SILVERUPGRADEGOLD);
        needPeopleController.saveNeedPeople(needPeopleYSJ);

        //铜牌升级金牌
        NeedPeople needPeopleTSJ = new NeedPeople();
        needPeopleTSJ.setGrade("铜牌升金牌");
        needPeopleTSJ.setAbbreviation("BUG");
        needPeopleTSJ.setPeople(9);
        needPeopleTSJ.setUpgrade(StatusSummary.UpgradeTo.BRONZEUPGRADEGOLD);
        needPeopleController.saveNeedPeople(needPeopleTSJ);

    }

}