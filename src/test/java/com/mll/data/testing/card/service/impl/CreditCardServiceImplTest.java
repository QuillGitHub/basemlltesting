package com.mll.data.testing.card.service.impl;

import com.mll.data.testing.card.service.CreditCardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditCardServiceImplTest {

    @Autowired
    private CreditCardService creditCardService;

    @Test
    public void deleteCreditCardByCardNumber() throws Exception {
        creditCardService.deleteCreditCardByCardNumber("12345678901");
    }

}