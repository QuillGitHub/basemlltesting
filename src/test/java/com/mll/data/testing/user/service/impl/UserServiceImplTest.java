package com.mll.data.testing.user.service.impl;

import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void save(){
        User user = new User();
        user.setLoginName("zhanghao");
        user.setPwd("mima");
        userService.save(user);
    }

}