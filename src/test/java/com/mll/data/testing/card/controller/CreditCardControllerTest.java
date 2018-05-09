package com.mll.data.testing.card.controller;

import com.mll.data.testing.card.entity.CreditCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditCardControllerTest {

    @Autowired
    private CreditCardController creditCardController;

    @Test
    public void saveCreditCard() throws Exception {
        CreditCard creditCard = new CreditCard();
        creditCard.setUserId("94d384fc411a11e89aa2c85b76076a87");//用户id
        creditCard.setAffiliatedBank("招商银行");//信用卡所属银行
        creditCard.setCardNumber("1234567890");//信用卡号
        creditCard.setValidityDate("20180406");//有效期至
        creditCard.setCvn("1234567");//信用卡安全码
        creditCard.setReservedPhoneNumber("13323332333");
        creditCardController.saveCreditCard(creditCard);
    }

    @Test
    public void updateCredit(){
    }

}