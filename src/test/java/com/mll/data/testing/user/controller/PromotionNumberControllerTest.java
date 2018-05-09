package com.mll.data.testing.user.controller;

import com.mll.data.testing.user.entity.PromotionNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PromotionNumberControllerTest {

    @Autowired
    private PromotionNumberController promotionNumberController;

    @Test
    public void savePromotionNumber() throws Exception {
        PromotionNumber promotionNumber = new PromotionNumber();
        promotionNumber.setUserId("fe9c9e893f1811e89aa2c85b76076a87");
        promotionNumber.setCertificationNumber(0);
        promotionNumber.setDirectGoldNumber(0);
        promotionNumber.setDirectSilverNumber(0);
        promotionNumber.setDirectBronzeNumber(0);
        promotionNumber.setIndirectGoldNumber(0);
        promotionNumber.setIndirectSilverNumber(0);
        promotionNumber.setIndirectBronzeNumber(0);
        promotionNumberController.savePromotionNumber(promotionNumber);
    }

    @Test
    public void findPromotionNumberByUserId(){
        String userId = "fe9c9e893f1811e89aa2c85b76076a87";
        promotionNumberController.findPromotionNumberByUserId(userId);
    }
}