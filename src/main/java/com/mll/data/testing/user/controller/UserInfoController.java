package com.mll.data.testing.user.controller;

import com.mll.data.testing.medal.service.MedalGradeService;
import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.entity.UserInfo;
import com.mll.data.testing.user.service.UserInfoService;
import com.mll.data.testing.user.service.UserService;
import com.mll.data.testing.user.vo.UserInfoVO;
import com.mll.data.testing.user.vo.UserInfoVO2;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private MedalGradeService medalGradeService;
    /**
     * 保存 保存用户信息
     * @param
     * @return
     */
    @PostMapping("/save")
    public String saveUserInfo(UserInfo userInfo){
        //用户id不能为空
        if(userInfo.getUserId() == null){
            //必须要有userId
            return JSONUtil.assemble(Result.FAILURE,"保存用户信息失败1");
        }else if(userInfoService.findUserInfoByUserId(userInfo.getUserId()) != null) {
            // userId 不能重复
            return JSONUtil.assemble(Result.FAILURE,"保存用户信息失败2");
        }else if(userService.findUserByid(userInfo.getUserId()) == null){
            //用户表中不能没有这个id
            return JSONUtil.assemble(Result.FAILURE,"保存用户信息失败3");
        }
        userInfoService.save(userInfo);

        //保存用户推广人数
        /*Map<String,Object> jsonMap = (Map)JSONObject.parse(json);
        UserInfo userInfos = JSON.parseObject(jsonMap.get("userInfo").toString(),new TypeReference<UserInfo>(){});
        User users = JSON.parseObject(jsonMap.get("userInfo").toString(),new TypeReference<User>(){});*/
        //保存用户信息
        return JSONUtil.assemble(Result.SUCCESS,"保存用户信息成功");
    }

    /**
     * 查询 根据 userId 返回用户信息对象
     * @param userId
     * @return
     */
    @GetMapping("/findUserInfoByUserId")
    public String findUserInfoByUserId(String userId){
        UserInfo userInfo = userInfoService.findUserInfoByUserId(userId);
        if(userInfo == null){
            return JSONUtil.assemble(Result.FAILURE,"没有该用户信息");
        }
        return JSONUtil.assemble(Result.SUCCESS,"查询到该用户信息");
    }

    /**
     * 查询 根据用户id 返回用户主界面展示信息
     * @param userId
     * @return
     */
    @GetMapping("/findUserInfoVO")
    public String findUserInfoVO(String userId){

        // 获取 用户信息
        User user = userService.findUserByid(userId);
        if(user != null) {
            UserInfo userInfo = userInfoService.findUserInfoByUserId(userId);
        }
        if (user.getAuthentication() == 2 && userService.findUserByPhone(user.getRefereePhone()) != null) { // 用户已认证，有邀请人
            UserInfoVO userInfoVO = new UserInfoVO();// 账号 手机号 牌型 直接上级名字  直接上级手机号 头像
            userInfoVO.setLoginName(user.getLoginName());
            userInfoVO.setPhone(user.getPhone());
            userInfoVO.setMedal(medalGradeService.findMedalGradeById(user.getMedal()).getGrade());
            userInfoVO.setDirectSuperior(userInfoService.findUserInfoByUserId(userService.findUserByPhone(user.getRefereePhone()).getId()).getFullName());
            userInfoVO.setDirectSuperiorPhone(user.getRefereePhone());
            userInfoVO.setPortrait("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=983130564,871086234&fm=27&gp=0.jpg");//头像
            return JSONUtil.assemble(Result.SUCCESS,userInfoVO,"查询到该用户信息1"); //用户已认证，有邀请人
        }else if(user.getAuthentication() == 2 &&  userService.findUserByPhone(user.getRefereePhone()) == null){ // 用户 已认证 无邀请人
            UserInfoVO userInfoVO = new UserInfoVO();// 账号 手机号 牌型 直接上级名字  直接上级手机号 头像
            userInfoVO.setLoginName(user.getLoginName());
            userInfoVO.setPhone(user.getPhone());
            userInfoVO.setMedal(medalGradeService.findMedalGradeById(user.getMedal()).getGrade());
            userInfoVO.setPortrait("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=983130564,871086234&fm=27&gp=0.jpg");//头像
            return JSONUtil.assemble(Result.SUCCESS,userInfoVO,"查询到该用户信息2"); // 用户已认证，无邀请人
        }

        if (user.getAuthentication() == 1 && userService.findUserByPhone(user.getRefereePhone()) != null) { //用户未认证，有邀请人
            UserInfoVO userInfoVO = new UserInfoVO();// 账号 手机号 牌型 直接上级名字  直接上级手机号 头像
            userInfoVO.setLoginName(user.getLoginName());
            userInfoVO.setPhone(user.getPhone());
            userInfoVO.setDirectSuperior(userInfoService.findUserInfoByUserId(userService.findUserByPhone(user.getRefereePhone()).getId()).getFullName());
            userInfoVO.setDirectSuperiorPhone(user.getRefereePhone());
            //userInfoVO.setPortrait("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=983130564,871086234&fm=27&gp=0.jpg");//头像
            return JSONUtil.assemble(Result.SUCCESS,userInfoVO,"查询到该用户信息3"); //用户未认证，有邀请人
        }else if(user.getAuthentication() == 1 && userService.findUserByPhone(user.getRefereePhone()) == null){
            UserInfoVO userInfoVO = new UserInfoVO();// 账号 手机号 牌型 直接上级名字  直接上级手机号 头像
            userInfoVO.setLoginName(user.getLoginName());
            userInfoVO.setPhone(user.getPhone());
            return JSONUtil.assemble(Result.SUCCESS,userInfoVO,"查询到该用户信息4"); // 用户未认证，无邀请人
        }




       /* if(userInfo != null){//用户已经认证

            if(userService.findUserByPhone(user.getRefereePhone()) != null){ // 有邀请人
                User refereeUser = userService.findUserByPhone(user.getRefereePhone()); // 邀请人user对象
                if(refereeUser.getAuthentication() == 2){  // 邀请人认证过
                    UserInfoVO userInfoVO = new UserInfoVO();// 账号 手机号 牌型 直接上级名字  直接上级手机号 头像
                    userInfoVO.setLoginName(user.getLoginName());
                    userInfoVO.setPhone(user.getPhone());
                    userInfoVO.setMedal(medalGradeService.findMedalGradeById(user.getMedal()).getGrade());
                    userInfoVO.setDirectSuperior(userInfoService.findUserInfoByUserId(refereeUser.getId()).getFullName());
                    userInfoVO.setDirectSuperiorPhone(refereeUser.getPhone());
                    userInfoVO.setPortrait("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=983130564,871086234&fm=27&gp=0.jpg");//头像
                    return JSONUtil.assemble(Result.SUCCESS,userInfoVO,"查询到该用户信息1"); //用户已认证，有邀请人，邀请人已认证
                }else{ // 邀请人未认证
                    UserInfoVO userInfoVO = new UserInfoVO();// 账号 手机号 牌型 直接上级名字  直接上级手机号 头像
                    userInfoVO.setLoginName(user.getLoginName());
                    userInfoVO.setPhone(user.getPhone());
                    userInfoVO.setMedal(medalGradeService.findMedalGradeById(user.getMedal()).getGrade());
                    userInfoVO.setDirectSuperiorPhone(user.getRefereePhone());
                    userInfoVO.setPortrait("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=983130564,871086234&fm=27&gp=0.jpg");//头像
                    return JSONUtil.assemble(Result.SUCCESS,userInfoVO,"查询到该用户信息2");//用户已认证，有邀请人，邀请人未认证
                }
            }else{ // 没有邀请人

            }

        }
        if(userInfo == null){//用户没有认证

        }
        return JSONUtil.assemble(Result.FAILURE,"获取信息失败");*/
       /* UserInfo userInfoTemp = userInfoService.findUserInfoByUserId(userId);
        if( userInfoTemp != null) { // 用户已经认证，有没有邀请人都可返回信息
            UserInfo userInfo = userInfoService.findUserInfoByUserId(userId);
            User user = userService.findUserByid(userId);
            UserInfoVO userInfoVO = new UserInfoVO();
            BeanUtils.copyProperties(userInfo, userInfoVO);
            userInfoVO.setLoginName(user.getLoginName());
            userInfoVO.setPhone(user.getPhone());
            userInfoVO.setMedal(medalGradeService.findMedalGradeById(user.getMedal()).getGrade());//获取牌型
            userInfoVO.setPortrait("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=983130564,871086234&fm=27&gp=0.jpg");//头像
            if(userService.findUserByid(userInfoVO.getDirectSuperior())!= null){// 有直接推荐人
                userInfoVO.setDirectSuperiorPhone(userService.findUserByid(userInfoVO.getDirectSuperior()).getPhone());//推荐人手机号
                userInfoVO.setDirectSuperior(userInfoService.findUserInfoByUserId(userInfoVO.getDirectSuperior()).getFullName());//推荐人姓名
                return JSONUtil.assemble(Result.SUCCESS,userInfoVO,"查询到该用户信息1"); //  有直接邀请人
            }
            return JSONUtil.assemble(Result.SUCCESS, userInfoVO, "查询到该用户信息2");// 没有直接邀请人
        }else if(userInfoTemp == null && userService.findUserByid(userId).getRefereePhone() == null){ // 没认证 邀请人手机号为空（没有邀请人）
            User user = userService.findUserByid(userId);
            UserInfoVO userInfoVO = new UserInfoVO();
            userInfoVO.setLoginName(user.getLoginName());
            userInfoVO.setPhone(user.getPhone());
            //userInfoVO
            return JSONUtil.assemble(Result.SUCCESS, userInfoVO, "查询到该用户信息3");// 没认证 没邀请人
        }else{ // 没认证  邀请人手机号不为空（有邀请人）
        //if(userInfoTemp == null && userService.findUserByid(userId).getRefereePhone() != null){
            User user = userService.findUserByid(userId);
            UserInfoVO userInfoVO = new UserInfoVO();
            userInfoVO.setLoginName(user.getLoginName());
            userInfoVO.setPhone(user.getPhone());
            userInfoVO.setDirectSuperiorPhone(user.getRefereePhone());
            //获取推荐人 用户信息
            UserInfo userInfo = userInfoService.findUserInfoByUserId((userService.findUserByPhone(user.getRefereePhone())).getId());
            if(userInfo ! = null) {
                userInfoVO.setDirectSuperior(userInfo.getFullName());//没认证 邀请人有认证
                return JSONUtil.assemble(Result.SUCCESS, userInfoVO, "查询到该用户信息4");
            }
            return JSONUtil.assemble(Result.SUCCESS, userInfoVO, "查询到该用户信息5"); //没认证 邀请人也没有认证
        }*/
       return JSONUtil.assemble(Result.FAILURE,"查询失败");
    }

    /**
     * 查询 根据用户id 返回用户基本信息
     * @param userId
     * @return
     */
    @GetMapping("/findUserInfoVO2")
    public String findUserInfoVO2(String userId){
        UserInfoVO2 userInfoVO2 = new UserInfoVO2();
        UserInfo userInfo = userInfoService.findUserInfoByUserId(userId);
        BeanUtils.copyProperties(userInfo,userInfoVO2);
        User user = userService.findUserByid(userId);
        userInfoVO2.setLoginName(user.getLoginName());
        return JSONUtil.assemble(Result.SUCCESS,userInfoVO2,"查询到该用户基本信息");
    }
}
