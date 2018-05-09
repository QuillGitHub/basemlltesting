package com.mll.data.testing.card.controller;

import com.mll.data.testing.card.entity.UserBankInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserBankInfoControllerTest {

    @Autowired
    private UserBankInfoController userBankInfoController;

    @Test
    public void saveUserBankInfo() throws Exception {
        UserBankInfo userBankInfo = new UserBankInfo();
        userBankInfo.setUserId("94d384fc411a11e89aa2c85b76076a87");//liuchuanzhi 柳传志
        userBankInfo.setCardType(1);//1 储蓄卡 2信用卡
        userBankInfo.setCardId("1234567890123456789");
        userBankInfo.setStatus(2);
        userBankInfoController.saveUserBankInfo(userBankInfo);
    }

    @Test
    public void find(){
        Map<String, Object> filters = new HashMap<>();
        Integer cardType = 1;
        Integer status = 1;
        //List<UserBankInfo> userBankInfoList = userBankInfoController.findUserBankInfoByUserIdAndCardTypeAndStatusList("10e1b2fd450f11e8ae03c85b76076a87",cardType,status);
    }
}