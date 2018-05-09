package com.mll.data.testing.user.service.impl;

import com.mll.data.testing.medal.service.MedalGradeService;
import com.mll.data.testing.share.StatusSummary;
import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.mapper.UserMapper;
import com.mll.data.testing.user.service.UserService;
import com.mll.data.testing.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MedalGradeService medalGradeService;

    /**
     * 保存 注册保存用户
     * @param user
     */
    @Override
    public void save(User user){
        //统一赋予 铜牌
        user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("TP").getId());
        //统一未认证
        user.setAuthentication(StatusSummary.Authentication.UNCERTIFIED);
        //统一正常
        user.setStatus(StatusSummary.Account.NORMAL);
        //统一打开隐私
        user.setPrivacy(StatusSummary.PrivacSwitch.OPEN);
        //保存用户
        userMapper.insert(user);
    }

    /**
     * 查询 根据用户名查询 返回对象
     * @return
     */
    @Override
    public User findUserByLoginName(String loginName){
        User user = userMapper.findUserByLoginName(loginName);
        return user;
    }

    /**
     * 查询 根据手机号 返回对象
     * @param phone
     * @return
     */
    @Override
    public User findUserByPhone(String phone){
        return userMapper.findUserByPhone(phone);
    }

    /**
     * 更新 更新用户密码
     * @param filter
     */
    @Override
    public void updateUserPwd(Map<String,Object> filter){
        userMapper.updateUserPwd(filter);
    }

    /**
     * 更新 更新用户信息
     * @param filter
     */
    @Override
    public void updateUser(Map<String, Object> filter){
        userMapper.updateUser(filter);
    }

    /**
     * 查询 登录返回所需用户信息
     * @param id
     * @return
     */
    @Override
    public UserVO findUserVO(String id){
        return userMapper.findUserVO(id);
    }



    @Override
    public User findUserByid(String id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }


    @Override
    public List<User> findAll(){
        List<User> listUser = userMapper.findAll();
        return listUser;
    }
}
