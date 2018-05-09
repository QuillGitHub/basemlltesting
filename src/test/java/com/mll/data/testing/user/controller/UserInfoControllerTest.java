package com.mll.data.testing.user.controller;

import com.mll.data.testing.user.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserInfoControllerTest {

    @Autowired
    private UserInfoController userInfoController;

    @Test
    public void saveUserInfo() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("fe9c9e893f1811e89aa2c85b76076a87");
        userInfo.setFullName("柳传志");
        userInfo.setSex(1);
        userInfo.setIdentityId("430105197902116416");

        userInfoController.saveUserInfo(userInfo);
    }

}