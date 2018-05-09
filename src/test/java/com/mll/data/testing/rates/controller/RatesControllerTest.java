package com.mll.data.testing.rates.controller;

import com.mll.data.testing.rates.entity.Rates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RatesControllerTest {

    @Autowired
    private RatesController ratesController;

    @Test
    public void saveRates() throws Exception {

        String[] arrName ={
                "快捷支付",
                "微信支付",
                "支付宝支付"
        } ;

        for(int i = 0 ; i < arrName.length ; i++){
            //铜牌 有积分
            Rates ratesT = new Rates();
            ratesT.setGradeId("d68ae9bf3e5211e89aa2c85b76076a87"); // 铜牌
            ratesT.setName(arrName[i]);
            ratesT.setRates(new BigDecimal(0.0045)); // 费率
            ratesT.setSettlement(new BigDecimal(2.00)); // 结算 费用 2元/笔
            ratesT.setQuota(8000); // 额度
            ratesT.setIntegral(1); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(ratesT);

            //铜牌 无积分
            Rates rates1 = new Rates();
            rates1.setGradeId("d68ae9bf3e5211e89aa2c85b76076a87"); // 铜牌
            rates1.setName(arrName[i]);
            rates1.setRates(new BigDecimal(0.0035)); // 费率
            rates1.setSettlement(new BigDecimal(2)); // 结算 费用 2元/笔
            rates1.setQuota(8000); // 额度
            rates1.setIntegral(2); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(rates1);

            //银牌 有积分
            Rates ratesY = new Rates();
            ratesY.setGradeId("d696d1913e5211e89aa2c85b76076a87"); // 银牌
            ratesY.setName(arrName[i]);
            ratesY.setRates(new BigDecimal(0.0040)); // 费率
            ratesY.setSettlement(new BigDecimal(2)); // 结算 费用 2元/笔
            ratesY.setQuota(10000); // 额度
            ratesY.setIntegral(1); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(ratesY);

            //银牌 无积分
            Rates rates2 = new Rates();
            rates2.setGradeId("d696d1913e5211e89aa2c85b76076a87"); // 银牌
            rates2.setName(arrName[i]);
            rates2.setRates(new BigDecimal(0.0030)); // 费率
            rates2.setSettlement(new BigDecimal(2)); // 结算 费用 2元/笔
            rates2.setQuota(10000); // 额度
            rates2.setIntegral(2); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(rates2);

            //金牌 无积分
            Rates ratesJ = new Rates();
            ratesJ.setGradeId("d697d9df3e5211e89aa2c85b76076a87"); // 金牌
            ratesJ.setName(arrName[i]);
            ratesJ.setRates(new BigDecimal(0.0038)); // 费率
            ratesJ.setSettlement(new BigDecimal(2)); // 结算 费用 2元/笔
            ratesJ.setQuota(20000); // 额度
            ratesJ.setIntegral(1); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(ratesJ);

            //金牌 无积分
            Rates rates3 = new Rates();
            rates3.setGradeId("d697d9df3e5211e89aa2c85b76076a87"); // 金牌
            rates3.setName(arrName[i]);
            rates3.setRates(new BigDecimal(0.0028)); // 费率
            rates3.setSettlement(new BigDecimal(2)); // 结算 费用 2元/笔
            rates3.setQuota(20000); // 额度
            rates3.setIntegral(2); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(rates3);
        }
    }


}