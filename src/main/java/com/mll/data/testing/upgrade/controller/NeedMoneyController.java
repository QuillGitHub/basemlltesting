package com.mll.data.testing.upgrade.controller;

import com.mll.data.testing.upgrade.entity.NeedMoney;
import com.mll.data.testing.upgrade.service.NeedMoneyService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/NeedMoney")
public class NeedMoneyController {

    @Autowired
    private NeedMoneyService needMoneyService;

    @PostMapping("/save")
    public String saveNeedMoney(NeedMoney needMoney){
        needMoneyService.saveNeedMoney(needMoney);
        return JSONUtil.assemble(Result.SUCCESS,"保存成功");
    }

    @GetMapping("/findAll")
    public String findAll(){
        List<NeedMoney> needMoneyList = needMoneyService.findAll();
        return JSONUtil.assemble(Result.SUCCESS,needMoneyList,"查询所有升级所需金额");
    }

    @GetMapping("/findNeedMoneyByupgrade")
    public String findNeedMoneyByupgrade(Integer upgrade){
        NeedMoney needMoney = needMoneyService.findNeedMoneyByUpgrade(upgrade);
        return JSONUtil.assemble(Result.SUCCESS,needMoney,"查询升级到某一个牌型所需金额");
    }

}
