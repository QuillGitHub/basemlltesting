package com.mll.data.testing.acct.controller;

import com.mll.data.testing.acct.entity.Merchant;
import com.mll.data.testing.acct.service.MerchantService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("/save")
    public String saveMerchant(Merchant merchant){
        if(merchantService.findMerchantByUserId(merchant.getUserId()) != null){
            return JSONUtil.assemble(Result.FAILURE,"保存商户失败1"); // 该用户id 已经保存过
        }
        merchantService.saveMerchant(merchant);
        return JSONUtil.assemble(Result.SUCCESS,"保存商户成功");
    }

    @GetMapping("/findMerchantByUserId")
    public String findMerchantByUserId(String userId){
        Merchant merchant = merchantService.findMerchantByUserId(userId);
        return JSONUtil.assemble(Result.SUCCESS,"查询到该商户");
    }

}
