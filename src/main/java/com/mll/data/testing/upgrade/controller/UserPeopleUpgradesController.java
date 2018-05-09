package com.mll.data.testing.upgrade.controller;

import com.mll.data.testing.upgrade.entity.UserPeopleUpgrades;
import com.mll.data.testing.upgrade.service.UserPeopleUpgradesService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 20:23
 **/

@RestController
@RequestMapping("/UserPeopleUpgrades")
public class UserPeopleUpgradesController {

    @Autowired
    private UserPeopleUpgradesService userPeopleUpgradesService;

    @PostMapping("/save")
    public String saveUserPeopleUpgrades(UserPeopleUpgrades userPeopleUpgrades){
        userPeopleUpgrades.setLatestTime(new Date());
        userPeopleUpgradesService.saveUserPeopleUpgrades(userPeopleUpgrades);
        return JSONUtil.assemble(Result.SUCCESS,"保存推荐人数成功");
    }

    @GetMapping("/findUserPeopleUpgradesByUserId")
    public String findUserPeopleUpgradesByUserId(String userId){
        userPeopleUpgradesService.findUserPeopleUpgradesByUserId(userId);
        return JSONUtil.assemble(Result.SUCCESS,"查询到该用户升级方式");
    }

    /**
     * 更新 增加一个邀请人数
     * @param userId
     * @return
     */
    @GetMapping("/updateUserPeopleUpgradesByUserId")
    public String updateUserPeopleUpgradesByUserId(String userId){
        UserPeopleUpgrades userPeopleUpgrades = userPeopleUpgradesService.findUserPeopleUpgradesByUserId(userId);
        userPeopleUpgrades.setRecommendedNumber(userPeopleUpgrades.getRecommendedNumber() + 1);// 增加一个邀请人数
        userPeopleUpgradesService.updateUserPeopleUpgradesByUserId(userId,userPeopleUpgrades.getRecommendedNumber());
        return JSONUtil.assemble(Result.SUCCESS,"增加一个邀请人数");
    }
}
