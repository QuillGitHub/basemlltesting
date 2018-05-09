package com.mll.data.testing.user.mapper;

import com.mll.data.testing.user.entity.UserInfo;
import com.mll.data.testing.user.vo.UserInfoVO;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select * from t_user_info where user_id = #{userId}")
    UserInfo findUserInfoByUserId(String userId);

    public UserInfoVO findUserInfoVO(String userId);
}
