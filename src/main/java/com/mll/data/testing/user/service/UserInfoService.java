package com.mll.data.testing.user.service;

import com.mll.data.testing.user.entity.UserInfo;
import com.mll.data.testing.user.vo.UserInfoVO;

public interface UserInfoService {
    void save(UserInfo userInfo);

    UserInfo findUserInfoByUserId(String userId);

    UserInfoVO findUserInfoVO(String userId);
}
