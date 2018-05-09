package com.mll.data.testing.upgrade.mapper;

import com.mll.data.testing.upgrade.entity.NeedMoney;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeedMoneyMapper extends BaseMapper<NeedMoney> {

    @Select("select * from t_upgrade_type_money")
    public List<NeedMoney> findAll();

    @Select("select * from t_upgrade_type_money where upgrade = #{upgrade}")
    public NeedMoney findNeedMoneyByUpgrade(Integer upgrade);
}
