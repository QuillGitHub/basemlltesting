package com.mll.data.testing.acct.controller;

import com.mll.data.testing.acct.entity.Merchant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MerchantControllerTest {

    @Autowired
    private MerchantController merchantController;

    @Test
    public void saveMerchant() throws Exception {
        Merchant merchant = new Merchant();
        merchant.setUserId("94d384fc411a11e89aa2c85b76076a87");
        merchant.setName("联想");
        merchant.setAbbreviation("lenovo");
        merchant.setProvince(null);
        merchant.setCity("北京市");
        merchant.setCounty(null);
        merchant.setAddress("中国北京海淀区上地创业路6号");
        merchant.setEmail("CCTS@lenovo.com");
        merchantController.saveMerchant(merchant);

    }

}