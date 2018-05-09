package com.mll.data.testing.user.controller;

import com.mll.data.testing.auditing.entity.ExaminePhoto;
import com.mll.data.testing.auditing.service.ExaminePhotoService;
import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.service.UserInfoService;
import com.mll.data.testing.user.service.UserService;
import com.mll.data.testing.user.vo.UserVO;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExaminePhotoService examinePhotoService;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 保存 保存用户信息
     * @param user
     * @return
     */
    @PostMapping("/save")
    public String save(User user) {
        //用户名不能相同
        if (userService.findUserByLoginName(user.getLoginName()) != null) {
            return JSONUtil.assemble(Result.FAILURE, "用户注册失败1");
        //用户名与密码不能相同
        }else if(user.getLoginName().equals(user.getPwd())){
            return JSONUtil.assemble(Result.FAILURE, "用户注册失败2");
        }else if(userService.findUserByPhone(user.getPhone()) != null){//手机号已存在
            return JSONUtil.assemble(Result.FAILURE, "用户注册失败3");
        }else if(userService.findUserByPhone(user.getRefereePhone()) == null && user.getRefereePhone() != null){ // 推荐人手机号不存在
            return JSONUtil.assemble(Result.FAILURE, "用户注册失败4");
        }else if(userService.findUserByPhone(user.getRefereePhone()) != null){
            if(userService.findUserByPhone(user.getRefereePhone()).getAuthentication() == 1){ //推荐人未认证
                return JSONUtil.assemble(Result.FAILURE, "用户注册失败5");
            }
        }

        /*else if(userService.findUserByPhone(user.getRefereePhone()).getAuthentication() == 1){ //推荐人未认证
            return JSONUtil.assemble(Result.FAILURE, "用户注册失败5");
        }*/
        //用户注册保存成功
        userService.save(user);
        //保存认证图片表
        ExaminePhoto examinePhoto = new ExaminePhoto();
        examinePhoto.setUserId(userService.findUserByLoginName(user.getLoginName()).getId());
        examinePhotoService.saveExaminePhoto(examinePhoto);

        return JSONUtil.assemble(Result.SUCCESS,"用户注册成功");
    }

    /**
     * 登录 登录验证账号 密码
     * @param user
     * @return
     */
    @PostMapping("/signIn")
    public String signIn(User user){
        if(user.getLoginName().equals(user.getPwd())){//防止恶意登录，用户和密码相同
            return JSONUtil.assemble(Result.FAILURE,"用户或密码错误1");
        }
        User userValidation = userService.findUserByLoginName(user.getLoginName());
        if(userValidation == null){//用户账号不存在
            return JSONUtil.assemble(Result.FAILURE,"用户或密码错误2");
        }else{//账号密码错误
            if(!userValidation.getPwd().equals(user.getPwd())){
                return JSONUtil.assemble(Result.FAILURE,"用户或密码错误3");
            }
        }
        UserVO userVO = new UserVO();
        User userTemp = userService.findUserByLoginName(user.getLoginName());
        BeanUtils.copyProperties(userTemp,userVO);
        //查找 上级 姓名 手机号
        //userVO.setDirectSuperiorPhone((userService.findUserByid(userVO.getDirectSuperior())).getPhone());
        //userVO.setDirectSuperior(userInfoService.findUserInfoByUserId(userVO.getDirectSuperior()).getFullName());
        //userVO.setPortrait("http://img1.imgtn.bdimg.com/it/u=245852606,2569092174&fm=214&gp=0.jpg");
        //牌型
        //userVO.setMedal(medalGradeRatesService.findMedalGradeRatesById(userVO.getMedal()).getGrade());
        return JSONUtil.assemble(Result.SUCCESS,userVO,"登录成功");
    }

    /**
     * 查询 根据用户id 返回用户对象
     * @param id
     * @return
     */
    @GetMapping("/find")
    public String findUserById(String id){
        //String id = "0325eefa3dfd11e8b849c85b76076a87";
        User user = userService.findUserByid(id);
        return JSONUtil.assemble(Result.SUCCESS,user,"查找到该用户");
    }

    /**
     * 查询 根据手机号 返回对象
     * @param phone
     * @return
     */
    @GetMapping("/findUserByphone")
    public String findUserByPhone(String phone){
        User user = userService.findUserByPhone(phone);
        return JSONUtil.assemble(Result.SUCCESS,user,"查找到该用户");
    }

    /**
     * 查询 返回所有的用户对象
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(){
        List<User> userList = userService.findAll();
        return JSONUtil.assemble(Result.SUCCESS,userList,"返回所有的用户");
    }

    /**
     * 查询 根据登录名查询 返回对象
     * @param loginName
     * @return
     */
    @GetMapping("/findByLoginName")
    public String findUserByLoginName(String loginName){
        User user = userService.findUserByLoginName(loginName);
        //如果为空则没有该用户
        if(user == null){
            return JSONUtil.assemble(Result.FAILURE,"\u6ca1\u6709\u8be5\u7528\u6237");//没有该用户
        }
        return JSONUtil.assemble(Result.SUCCESS,"\u67e5\u8be2\u5230\u8be5\u7528\u6237");//查询到该用户
    }

    /**
     * 更新 更新用户密码
     * @param loginName
     * @param pwd
     * @return
     */
    @PostMapping("/updateUserPwd")
    public String updateUserPwd(//@RequestParam(value = "userId",required = true)String userId,
                                @RequestParam(value = "loginName",required = true)String loginName,
                                @RequestParam(value = "pwd",required = true)String pwd){
        if(userService.findUserByLoginName(loginName) == null){
            return JSONUtil.assemble(Result.FAILURE,"更新密码失败1");//账号
        }
        Map<String,Object> filters = new HashMap<>();
        filters.put("loginName",loginName);
        filters.put("pwd",pwd);
        userService.updateUserPwd(filters);
        return JSONUtil.assemble(Result.SUCCESS,"密码更新成功");
    }

    /**
     * 更新 更新用户信息
     * @param id
     * @param loginName
     * @param phone
     * @param medal
     * @param status
     * @param authentication
     * @param privacy
     * @return
     */
    @PostMapping("/updateUser")
    public String updateUser(@RequestParam(value = "id",required = true)String id,
                             @RequestParam(value = "loginName",required = false)String loginName,
                             @RequestParam(value = "phone",required = false)String phone,
                             @RequestParam(value = "medal",required = false)String medal,
                             @RequestParam(value = "status",required = false)String status,
                             @RequestParam(value = "authentication",required = false)String authentication,
                             @RequestParam(value = "privacy",required = false)String privacy){
        User user = userService.findUserByid(id);
        if(!user.getPhone().equals(user.getLoginName())){
            return JSONUtil.assemble(Result.FAILURE,"用户信息更新失败1");//账号不是手机号不能修改账号
        }
        Map<String, Object> filter = new HashMap<>();
        filter.put("id",id);
        if(loginName != null && user.getPhone().equals(user.getLoginName())){
            filter.put("loginName",loginName);
        }
        if(phone != null){
            filter.put("phone",phone);
        }
        if(medal != null){
            filter.put("medal",medal);
        }
        if(status != null){
            filter.put("status",status);
        }
        if(authentication != null){
            filter.put("authentication",authentication);
        }
        if(privacy != null){
            filter.put("privacy",privacy);
        }
        userService.updateUser(filter);
        return JSONUtil.assemble(Result.SUCCESS,"用户信息更新成功");
    }



    @PostMapping("/login")
    public String login(){
        return "";
    }

    @GetMapping("/em")
    public String get(){
        return JSONUtil.assemble(Result.SUCCESS,"访问成功");
    }
}
