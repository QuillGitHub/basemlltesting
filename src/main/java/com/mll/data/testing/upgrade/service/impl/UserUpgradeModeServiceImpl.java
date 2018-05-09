package com.mll.data.testing.upgrade.service.impl;

import com.mll.data.testing.upgrade.entity.UserUpgradeMode;
import com.mll.data.testing.upgrade.mapper.UserUpgradeModeMapper;
import com.mll.data.testing.upgrade.service.UserUpgradeModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 18:05
 **/

@Service
@Transactional
public class UserUpgradeModeServiceImpl implements UserUpgradeModeService {

    @Autowired
    private UserUpgradeModeMapper userUpgradeModeMapper;

    /**
     * 保存 保存用户升级方式
     * @param userUpgradeMode
     */
    @Override
    public void saveUserUpgradeMode(UserUpgradeMode userUpgradeMode){
        if(findUserUpgradeModeByUserId(userUpgradeMode.getUserId()) != null){ //如果用户id 存在，不添加
            return;
        }
        userUpgradeModeMapper.insert(userUpgradeMode);
    }

    /**
     * 查询 根据用户id 返回对象
     * @param userId
     * @return
     */
    @Override
    public UserUpgradeMode findUserUpgradeModeByUserId(String userId){
        return userUpgradeModeMapper.findUserUpgradeModeByUserId(userId);
    }

    /**
     * 更新 根据用户id  升级类型 更新对象
     * @param userId
     * @param upgradeType
     */
    @Override
    public void updateUserUpgradeMode(String userId,Integer upgradeType){
        Map<String, Object> filters = new HashMap<>();
        filters.put("userId",userId);
        filters.put("upgradeType",upgradeType);
        userUpgradeModeMapper.updateUserUpgradeMode(filters);
    }
}
