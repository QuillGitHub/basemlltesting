package com.mll.data.testing.user.mapper;

import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.vo.UserVO;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user")
    public List<User> findAll();

    @Select("select * from t_user where  login_name = #{loginName}")
    public User findUserByLoginName(String loginName);

    @Select("select * from t_user where phone = #{phone}")
    public User findUserByPhone(String phone);

    public UserVO findUserVO(String id);

    public void updateUserPwd(Map<String, Object> filter);

    public void updateUser(Map<String, Object> filter);
}
