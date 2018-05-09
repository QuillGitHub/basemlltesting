package com.mll.data.testing.user.mapper;

import com.mll.data.testing.user.entity.PromotionNumber;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PromotionNumberMapper extends BaseMapper<PromotionNumber> {

    @Select("select * from t_promotion_number where user_id = #{userId}")
    PromotionNumber findPromotionNumberByUserId(String userId);

    public void updatePromotionNumber(Map<String, Object> filters);
}
