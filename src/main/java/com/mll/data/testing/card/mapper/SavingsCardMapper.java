package com.mll.data.testing.card.mapper;

import com.mll.data.testing.card.entity.SavingsCard;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingsCardMapper extends BaseMapper<SavingsCard> {

    @Select("select * from t_savings_card where card_number =#{cardNumber}")
    public SavingsCard findSavingsCardByCardNumber(String cardNumber);

    @Select("select * from t_savings_card where user_id = #{userId}")
    public List<SavingsCard> findSavingsCardByUserIdList(String userId);

    @Delete("delete from t_savings_card where card_number = #{cardNumber}")
    public void deleteSavingsCardByCardNumber(String cardNumber);
}
