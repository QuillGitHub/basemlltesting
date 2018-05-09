package com.mll.data.testing.card.mapper;

import com.mll.data.testing.card.entity.UserBankInfo;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserBankInfoMapper extends BaseMapper<UserBankInfo>{

    @Select("select * from t_user_bank_info where card_id = #{cardId}")
    public UserBankInfo findUserBankInfoByCardId(String cardId);

    @Select("select * from t_user_bank_info where user_id = #{userId}")
    public List<UserBankInfo> findUserBankInfoByUserId(String userId);

    public UserBankInfo findUserBankInfoByCardIdAndCardType(Map<String,Object> filter);

    public List<UserBankInfo> findUserBankInfoByUserIdAndCardTypeAndStatusList(Map<String,Object> filter);

    @Select("select * from t_user_bank_info where id = #{id}")
    public UserBankInfo findUserBankInfoById(String id);

    @Delete("delete from t_user_bank_info where id = #{id}")
    public void deleteUserBankInfoById(String id);
}
