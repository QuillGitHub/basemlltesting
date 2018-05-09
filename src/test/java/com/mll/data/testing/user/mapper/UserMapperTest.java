package com.mll.data.testing.user.mapper;

import com.mll.data.testing.user.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findUserVO() throws Exception {
        //Map<String,Object> map = new HashMap<>();
        //map.put("id","10e1b2fd450f11e8ae03c85b76076a87");
        UserVO userVo = userMapper.findUserVO("10e1b2fd450f11e8ae03c85b76076a87");
        System.out.println(userVo);
    }

}