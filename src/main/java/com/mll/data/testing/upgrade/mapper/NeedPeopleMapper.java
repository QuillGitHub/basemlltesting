package com.mll.data.testing.upgrade.mapper;

import com.mll.data.testing.upgrade.entity.NeedPeople;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeedPeopleMapper extends BaseMapper<NeedPeople> {

    @Select("select * from t_upgrade_type_people")
    public List<NeedPeople> findAll();

    @Select("select * from t_upgrade_type_people where upgrade = #{upgrade}")
    public NeedPeople findNeedPeopleByUpgrade(Integer upgrade);


}
