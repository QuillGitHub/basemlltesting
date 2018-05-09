package com.mll.data.testing.user.service;

import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface UserService {

    void save(User user);

    User findUserByPhone(String phone);

    void updateUserPwd(Map<String, Object> filter);

    void updateUser(Map<String, Object> filter);

    UserVO findUserVO(String id);

    User findUserByid(String id);

    User findUserByLoginName(String loginName);

    List<User> findAll();
}
