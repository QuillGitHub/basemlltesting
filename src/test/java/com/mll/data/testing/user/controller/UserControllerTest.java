package com.mll.data.testing.user.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void save(){

    }

    @Test
    public void find(){
        String id = "0325eefa3dfd11e8b849c85b76076a87";
        //User user = userController.findUserById(id);
        //System.out.println(user);
    }

}