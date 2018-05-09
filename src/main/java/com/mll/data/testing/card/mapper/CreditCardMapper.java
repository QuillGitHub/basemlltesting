package com.mll.data.testing.card.mapper;

import com.mll.data.testing.card.entity.CreditCard;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CreditCardMapper extends BaseMapper<CreditCard> {

    @Select("select * from t_credit_card where card_number = #{cardNumber}")
    public CreditCard findCreditCardByByCardNumber(String cardNumber);

    @Select("select * from t_credit_card where user_id = #{userId}")
    public List<CreditCard> findCreditCardByUserIdList(String userId);

    @Delete("delete from t_credit_card where card_number = #{cardNumber}")
    public void deleteCreditCardByCardNumber(String cardNumber);

    public void updateCreditCard(Map<String, Object> filters);
}
