package com.mll.data.testing.rates.controller;

import com.mll.data.testing.rates.VO.RatesVO;
import com.mll.data.testing.rates.entity.Rates;
import com.mll.data.testing.rates.service.RatesService;
import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.service.UserService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 14:08
 **/
@RestController
@RequestMapping("/Rates")
public class RatesController {

    @Autowired
    private RatesService ratesService;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveRates(Rates rates){
        ratesService.saveRates(rates);
        return JSONUtil.assemble(Result.SUCCESS,"保存费率成功");
    }

    @GetMapping("/findRatesByGradeId")
    public String findRatesByGradeId(String gradeId){
        List<RatesVO> ratesVOList = ratesService.findRatesByGradeId(gradeId);
        return JSONUtil.assemble(Result.SUCCESS,ratesVOList,"查询到所有该等级的费率");
    }

    /**
     * 根据用户id 返回该用户所有可用费率
     * @param userId
     * @return
     */
    @GetMapping("/findRatesByUserId")
    public String findRatesByUserId(String userId){
        User user = userService.findUserByid(userId);
        List<RatesVO> ratesVOList = ratesService.findRatesByGradeId(user.getMedal());

        return JSONUtil.assemble(Result.SUCCESS,ratesVOList,"查询到该用户的费率");
    }
}
