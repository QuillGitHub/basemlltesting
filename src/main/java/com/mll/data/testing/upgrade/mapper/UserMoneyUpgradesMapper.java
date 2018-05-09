package com.mll.data.testing.upgrade.mapper;

import com.mll.data.testing.upgrade.entity.UserMoneyUpgrades;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UserMoneyUpgradesMapper extends BaseMapper<UserMoneyUpgrades> {

    @Select("SELECT * FROM t_user_money_upgrades WHERE user_id = #{userId} AND money = #{money}")
    public UserMoneyUpgrades findUserMoneyUpgradesByUserIdMoney(@Param("userId") String userId, @Param("money") BigDecimal money);
}
