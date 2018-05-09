package com.mll.data.testing.card.controller;

import com.mll.data.testing.card.entity.SavingsCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SavingsCardControllerTest {

    @Autowired
    private SavingsCardController savingsCardController;

    @Test
    public void saveSavingsCard() throws Exception {
        SavingsCard savingsCard = new SavingsCard();
        savingsCard.setUserId("94d384fc411a11e89aa2c85b76076a87");//用户id
        savingsCard.setAffiliatedBank("中国银行");
        savingsCard.setCardNumber("1111111110");//储蓄卡 卡号
        savingsCard.setCardAddress("河南省许昌市");
        savingsCard.setReservedPhoneNumber("18912345678");
        savingsCardController.saveSavingsCard(savingsCard);
    }

}