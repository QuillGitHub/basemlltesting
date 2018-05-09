package com.mll.data.testing.upgrade.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserUpgradeModeControllerTest {

    @Autowired
    private UserUpgradeModeController userUpgradeModeController;

    @Test
    public void upgradeMode() throws Exception {

        //userUpgradeModeController.upgradeMode("6a1a6c8f4a8c11e89f30c85b76076a87",1,1);
    }

}