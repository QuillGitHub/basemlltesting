package com.mll.data.testing.acct.mapper;

import com.mll.data.testing.acct.entity.Merchant;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantMapper extends BaseMapper<Merchant> {

    @Select("select * from t_merchant where user_id = #{userId}")
    public Merchant findMerchantByUserId(String userId);
}
