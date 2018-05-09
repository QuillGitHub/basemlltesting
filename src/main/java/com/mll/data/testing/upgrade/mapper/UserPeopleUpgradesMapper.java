package com.mll.data.testing.upgrade.mapper;

import com.mll.data.testing.upgrade.entity.UserPeopleUpgrades;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 20:14
 **/

@Repository
public interface UserPeopleUpgradesMapper extends BaseMapper<UserPeopleUpgrades> {

    @Select("select * from t_user_people_upgrades where user_id = #{userId}")
    public UserPeopleUpgrades findUserPeopleUpgradesByUserId(String userId);

    @Update("update t_user_people_upgrades set recommended_number = recommendedNumber where user_id = #{userId} ")
    public UserPeopleUpgrades updateUserPeopleUpgradesByUserId(String userId,Integer recommendedNumber);
}
