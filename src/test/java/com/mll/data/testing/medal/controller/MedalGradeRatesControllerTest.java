/*
package com.mll.data.testing.medal.controller;

import com.mll.data.testing.medal.entity.MedalGradeRates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedalGradeRatesControllerTest {

    @Autowired
    private MedalGradeRatesController medalGradeRatesController;

    */
/**
     * 测试 生成金银铜三级牌
     *//*

    @Test
    public void save(){
        //铜牌 0.0009
        MedalGradeRates medalGradeRatesT = new MedalGradeRates();
        medalGradeRatesT.setGrade("铜牌");
        medalGradeRatesT.setGradeAbbreviation("TP");
        medalGradeRatesT.setZfbRate(new BigDecimal(0.0009));
        medalGradeRatesT.setWxRate(new BigDecimal(0.0009));
        medalGradeRatesT.setNoCardRate(new BigDecimal(0.0009));
        medalGradeRatesT.settZeroMerchantRate(new BigDecimal(0.0009));
        medalGradeRatesT.settZeroPayoutRate(new BigDecimal(0.0009));
        medalGradeRatesController.save(medalGradeRatesT);

        //银牌 0.0007
        MedalGradeRates medalGradeRatesY = new MedalGradeRates();
        medalGradeRatesY.setGrade("银牌");
        medalGradeRatesY.setGradeAbbreviation("YP");
        medalGradeRatesY.setZfbRate(new BigDecimal(0.0007));
        medalGradeRatesY.setWxRate(new BigDecimal(0.0007));
        medalGradeRatesY.setNoCardRate(new BigDecimal(0.0007));
        medalGradeRatesY.settZeroMerchantRate(new BigDecimal(0.0007));
        medalGradeRatesY.settZeroPayoutRate(new BigDecimal(0.0007));
        medalGradeRatesController.save(medalGradeRatesY);

        //金牌 0.0007
        MedalGradeRates medalGradeRatesJ = new MedalGradeRates();
        medalGradeRatesJ.setGrade("金牌");
        medalGradeRatesJ.setGradeAbbreviation("JP");
        medalGradeRatesJ.setZfbRate(new BigDecimal(0.0005));
        medalGradeRatesJ.setWxRate(new BigDecimal(0.0005));
        medalGradeRatesJ.setNoCardRate(new BigDecimal(0.0005));
        medalGradeRatesJ.settZeroMerchantRate(new BigDecimal(0.0005));
        medalGradeRatesJ.settZeroPayoutRate(new BigDecimal(0.0005));
        medalGradeRatesController.save(medalGradeRatesJ);

    }

    */
/**
     * 测试 根据简称返回对象，用以修改费率
     *//*

    @Test
    public void findMedalGradeRatesByAbbreviation(){
        String abbreviation = "TP";
        MedalGradeRates medalGradeRates =medalGradeRatesController.findMedalGradeRatesByAbbreviation(abbreviation);
        System.out.println("打印出等级类型 id ：" + medalGradeRates.getId());
        System.out.println("打印出对象" + medalGradeRates);
    }
}*/
