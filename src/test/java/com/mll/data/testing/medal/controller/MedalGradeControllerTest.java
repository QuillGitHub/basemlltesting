package com.mll.data.testing.medal.controller;

import com.mll.data.testing.medal.entity.MedalGrade;
import com.mll.data.testing.medal.service.MedalGradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedalGradeControllerTest {

    @Autowired
    private MedalGradeController medalGradeController;

    @Autowired
    private MedalGradeService medalGradeService;

    @Test
    public void saveMedalGrade() throws Exception {
        //创建铜牌
        MedalGrade medalGradeB = new MedalGrade();
        medalGradeB.setGrade("铜牌");
        medalGradeB.setGradeAbbreviation("TP");
        medalGradeService.saveMedalGrade(medalGradeB);

        //创建银牌
        MedalGrade medalGradeS = new MedalGrade();
        medalGradeS.setGrade("银牌");
        medalGradeS.setGradeAbbreviation("YP");
        medalGradeService.saveMedalGrade(medalGradeS);


        //创建金牌
        MedalGrade medalGradeG = new MedalGrade();
        medalGradeG.setGrade("金牌");
        medalGradeG.setGradeAbbreviation("JP");
        medalGradeService.saveMedalGrade(medalGradeG);


    }

}