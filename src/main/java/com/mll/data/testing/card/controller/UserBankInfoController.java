package com.mll.data.testing.card.controller;

import com.mll.data.testing.card.entity.UserBankInfo;
import com.mll.data.testing.card.service.UserBankInfoService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/UserBankInfo")
public class UserBankInfoController {

    @Autowired
    private UserBankInfoService userBankInfoService;

    @PostMapping("/save")
    public String saveUserBankInfo(UserBankInfo userBankInfo){
        userBankInfoService.saveUserBankInfo(userBankInfo);
        return JSONUtil.assemble(Result.SUCCESS,"保存银行卡成功");
    }

    @GetMapping("/findUserBankInfoByCardId")
    public String findUserBankInfoByCardId(String cardId){
        UserBankInfo userBankInfo = userBankInfoService.findUserBankInfoByCardId(cardId);
        return JSONUtil.assemble(Result.SUCCESS,userBankInfo,"查询到银行卡");
    }

    @GetMapping("/findUserBankInfoByUserId")
    public String findUserBankInfoByUserId(String userId){
        List<UserBankInfo> list = userBankInfoService.findUserBankInfoByUserId(userId);
        return JSONUtil.assemble(Result.SUCCESS,list,"查询到用户所有银行卡信息");
    }

    @PostMapping("/findUserBankInfoByCardIdAndCardType")
    public String findUserBankInfoByCardIdAndCardType(@RequestParam( value = "cardId" , required = false)String cardId,
                                                      @RequestParam( value = "cardType", required = false)String cardType){
        Map<String, Object> filter = new HashMap<>();
        if(cardId != null) {
            filter.put("cardId",cardId);
        }
        if(cardType != null){
            filter.put("cardType",cardType);
        }
        UserBankInfo userBankInfo = userBankInfoService.findUserBankInfoByCardIdAndCardType(filter);
        return JSONUtil.assemble(Result.SUCCESS,"查询到该银行卡");
    }

    @PostMapping("/findUserBankInfoByUserIdAndCardTypeAndStatusList")
    public String findUserBankInfoByUserIdAndCardTypeAndStatusList(@RequestParam( value = "userId" , required = false)String userId,
                                                                   @RequestParam( value = "cardType" , required = false)Integer cardType,
                                                                   @RequestParam( value = "status" , required = false)Integer status){
        Map<String, Object> filters = new HashMap<>();
        if(userId != null) {
            filters.put("userId",userId);
        }
        if(cardType != null){
            filters.put("cardType",cardType);
        }
        if(status != null){
            filters.put("status",status);
        }
        List<UserBankInfo> userBankInfoList = userBankInfoService.findUserBankInfoByUserIdAndCardTypeAndStatusList(filters);
        return JSONUtil.assemble(Result.SUCCESS,userBankInfoList,"查询到符合状态的银行卡");
    }

    @GetMapping("/findUserBankInfoById")
    public String findUserBankInfoById(String id){
        UserBankInfo userBankInfo = userBankInfoService.findUserBankInfoById(id);
        return JSONUtil.assemble(Result.SUCCESS,userBankInfo,"查询到该银行卡");
    }

    @GetMapping("/deleteUserBankInfoById")
    public String deleteUserBankInfoById(String id){
        //判断 该银行卡存在与否
        if(userBankInfoService.findUserBankInfoById(id) == null){
            return JSONUtil.assemble(Result.FAILURE,"删除该银行卡失败1");//这个id 不存在
        }
        userBankInfoService.deleteUserBankInfoById(id);
        return JSONUtil.assemble(Result.SUCCESS,"删除该银行卡成功");
    }
}
