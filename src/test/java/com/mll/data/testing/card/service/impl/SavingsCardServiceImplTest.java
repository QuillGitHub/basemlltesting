package com.mll.data.testing.card.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SavingsCardServiceImplTest {

    @Autowired
    private SavingsCardServiceImpl savingsCardService;

    @Test
    public void deleteSavingsCardByCardNumber() throws Exception {
        savingsCardService.deleteSavingsCardByCardNumber("987654321");
    }

}