package com.mll.data.testing.card.mapper;

import com.mll.data.testing.card.entity.UserBankInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserBankInfoMapperTest {

    @Autowired
    private UserBankInfoMapper userBankInfoMapper;

    @Test
    public void findUserBankInfoByCardIdAndCardType(){
       Map<String,Object> map = new HashMap<>();
       map.put("cardId","34e09e8c422511e8ae03c85b76076a87");
       map.put("cardType",1);
       UserBankInfo userBankInfo = userBankInfoMapper.findUserBankInfoByCardIdAndCardType(map);
       System.out.println(userBankInfo.getId());
    }

    @Test
    public void find(){
        Map<String,Object> map = new HashMap<>();
        map.put("userId","10e1b2fd450f11e8ae03c85b76076a87");
        map.put("cardType",1);
        map.put("status",2);
        List<UserBankInfo> userBankInfoList = userBankInfoMapper.findUserBankInfoByUserIdAndCardTypeAndStatusList(map);
        int i = 0 ;
        for(UserBankInfo u : userBankInfoList){
            i++;
        }
        System.out.println("--------------------------符合个数 ： " + i );




    }
}