package com.mll.data.testing.upgrade.service.impl;

import com.mll.data.testing.upgrade.entity.UserPeopleUpgrades;
import com.mll.data.testing.upgrade.mapper.UserPeopleUpgradesMapper;
import com.mll.data.testing.upgrade.service.UserPeopleUpgradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 20:21
 **/

@Service
@Transactional
public class UserPeopleUpgradesServiceImpl implements UserPeopleUpgradesService{

    @Autowired
    private UserPeopleUpgradesMapper userPeopleUpgradesMapper;

    /**
     * 保存 推荐人数总数
     * @param userPeopleUpgrades
     */
    @Override
    public void saveUserPeopleUpgrades(UserPeopleUpgrades userPeopleUpgrades){
        userPeopleUpgradesMapper.insert(userPeopleUpgrades);
    }

    /**
     * 查询 根据用户id 查询用户邀请人数
     * @param userId
     * @return
     */
    @Override
    public UserPeopleUpgrades findUserPeopleUpgradesByUserId(String userId){
        return userPeopleUpgradesMapper.findUserPeopleUpgradesByUserId(userId);
    }

    /**
     * 更新 根据用户id 邀请人数 返回对象
     * @param userId
     * @param recommendedNumber
     * @return
     */
    @Override
    public UserPeopleUpgrades updateUserPeopleUpgradesByUserId(String userId,Integer recommendedNumber){
        return userPeopleUpgradesMapper.updateUserPeopleUpgradesByUserId(userId,recommendedNumber);
    }

}
