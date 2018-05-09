package com.mll.data.testing.upgrade.mapper;

import com.mll.data.testing.upgrade.entity.UserUpgradeMode;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserUpgradeModeMapper extends BaseMapper<UserUpgradeMode> {

    @Select("select * from t_user_upgrade_mode where user_id = #{userId} ")
    public UserUpgradeMode findUserUpgradeModeByUserId(String userId);

    public void updateUserUpgradeMode(Map<String, Object> filters);
}
