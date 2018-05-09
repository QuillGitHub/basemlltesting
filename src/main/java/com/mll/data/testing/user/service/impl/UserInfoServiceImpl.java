package com.mll.data.testing.user.service.impl;

import com.mll.data.testing.acct.entity.Merchant;
import com.mll.data.testing.acct.service.MerchantService;
import com.mll.data.testing.share.StatusSummary;
import com.mll.data.testing.user.entity.PromotionNumber;
import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.entity.UserInfo;
import com.mll.data.testing.user.mapper.UserInfoMapper;
import com.mll.data.testing.user.service.PromotionNumberService;
import com.mll.data.testing.user.service.UserInfoService;
import com.mll.data.testing.user.service.UserService;
import com.mll.data.testing.user.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private PromotionNumberService promotionNumberService;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private UserService userService;

    /**
     * 保存 用户信息
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo){
        //判断传入用户的信息正确性，例如上级手机号是否存在(需求暂不用手机号，该选项保留)

        //保存用户直接上级，间接上级
        User user = userService.findUserByid(userInfo.getUserId()); // 认证的用户信息
        User refereeUser = userService.findUserByPhone(user.getRefereePhone()); // 直接邀请人用户信息
        if(refereeUser != null){
            userInfo.setDirectSuperior(refereeUser.getId());
            User indirectUser =userService.findUserByPhone(refereeUser.getRefereePhone()); // 间接邀请人信息
            if(indirectUser != null){
                userInfo.setIndirectSuperior(indirectUser.getId());
            }
        }
        //用户性别暂时保密
        userInfo.setSex(StatusSummary.Sex.UNKNOW);
        //保存的注册时间
        userInfo.setCreateTime(new Date());
        //保存登录最后一次登录时间
        userInfo.setLastTime(new Date());

        //保存推荐人数
        PromotionNumber promotionNumber = new PromotionNumber();
        promotionNumber.setUserId(userInfo.getUserId());
        promotionNumberService.savePromotionNumber(promotionNumber);

        //保存商户表
        Merchant merchant = new Merchant();
        merchant.setUserId(userInfo.getUserId());
        merchantService.saveMerchant(merchant);

        //判断性别 0 未知，1 男，2 女
        //userInfo.setSex(userInfo.getSex() == 1 ? StatusSummary.Sex.MALE : (userInfo.getSex() == 2 ? StatusSummary.Sex.FEMALE : StatusSummary.Sex.UNKNOW));
        userInfoMapper.insert(userInfo);

    }

    /**
     * 查询 根据userid 返回用户信息 对象
     * @param userId
     * @return
     */
    @Override
    public UserInfo findUserInfoByUserId(String userId){
       UserInfo userInfo = userInfoMapper.findUserInfoByUserId(userId);
       return userInfo;
    }

    /**
     * 查询 根据用户id 返回用户界面展示信息
     * @param userId
     * @return
     */
    @Override
    public UserInfoVO findUserInfoVO(String userId){
        return userInfoMapper.findUserInfoVO(userId);
    }

}
