package com.mll.data.testing.upgrade.controller;

import com.mll.data.testing.upgrade.entity.NeedPeople;
import com.mll.data.testing.upgrade.service.NeedPeopleService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("NeedPeople")
public class NeedPeopleController {

    @Autowired
    private NeedPeopleService needPeopleService;

    @RequestMapping("/save")
    public String saveNeedPeople(NeedPeople needPeople){
        needPeopleService.saveNeedPeople(needPeople);
        return JSONUtil.assemble(Result.SUCCESS,"保存成功");
    }

    @GetMapping("/findAll")
    public String findAll(){
        List<NeedPeople> peopleList = needPeopleService.findAll();
        return JSONUtil.assemble(Result.SUCCESS,peopleList,"查询所有升级所需人数");
    }

    @GetMapping("/findNeedPeopleByUpgrade")
    public String findNeedPeopleByUpgrade(Integer upgrade){
        NeedPeople needPeople = needPeopleService.findNeedPeopleByUpgrade(upgrade);
        return JSONUtil.assemble(Result.SUCCESS,needPeople,"查询升级到某一个牌型所需邀请人数");
    }
}
