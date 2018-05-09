package com.mll.data.testing.rates.service.impl;

import com.mll.data.testing.rates.VO.RatesVO;
import com.mll.data.testing.rates.controller.RatesController;
import com.mll.data.testing.rates.service.RatesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RatesServiceImplTest {

    @Autowired
    private RatesController ratesController;

    @Autowired
    private RatesService ratesService;

    @Test
    public void findRatesByGradeId() throws Exception {
       List<RatesVO> ratesVOList = ratesService.findRatesByGradeId("0d5255184dba11e88d2ac85b76076a87");
       for(RatesVO r : ratesVOList){
           System.out.println(r);
       }
    }

}