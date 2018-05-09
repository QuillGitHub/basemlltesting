package com.mll.data.testing.card.service.impl;

import com.mll.data.testing.card.entity.CreditCard;
import com.mll.data.testing.card.entity.UserBankInfo;
import com.mll.data.testing.card.mapper.CreditCardMapper;
import com.mll.data.testing.card.service.CreditCardService;
import com.mll.data.testing.card.service.UserBankInfoService;
import com.mll.data.testing.share.StatusSummary;
import com.mll.data.testing.user.entity.PromotionNumber;
import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.service.PromotionNumberService;
import com.mll.data.testing.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardMapper creditCardMapper;

    @Autowired
    private UserBankInfoService userBankInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private PromotionNumberService promotionNumberService;

    /**
     * 保存 用户信用卡
     * @param creditCard
     */
    @Override
    public void saveCreditCard(CreditCard creditCard){
        //判断不能有重复的卡
        if((findCreditCardByByCardNumber(creditCard.getCardNumber()) != null)){
            return;//卡号重复
        }
        //保存到用户银行卡信息表
        UserBankInfo userBankInfo = new UserBankInfo();
        userBankInfo.setUserId(creditCard.getUserId());
        userBankInfo.setCardType(StatusSummary.CardType.CREDIT);//卡类型信用卡
        userBankInfo.setStatus(StatusSummary.Authentication.UNCERTIFIED);//未认证
        creditCardMapper.insert(creditCard);
        CreditCard tepmCC = findCreditCardByByCardNumber(creditCard.getCardNumber());
        userBankInfo.setCardId(tepmCC.getId());
        userBankInfoService.saveUserBankInfo(userBankInfo);//保存卡信息

        /**
         * 认证通过添加推荐人数 （该段代码可能要调整位置，可整块移走）
         */

        //获取该用户信息
        User user = userService.findUserByid(creditCard.getUserId());
        //通过推荐人手机号获取直接推荐人信息
        User directUser = userService.findUserByPhone(user.getRefereePhone());
        if(directUser == null ){//如果对象为空证明没有推荐人，结束return
            return;
        }
        //获取直接推荐人的推荐人数表
        PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
        //修改其中的值
        Map<String, Object> directFilters = new HashMap<>();
        directFilters.put("userId",directPromotionNumber.getUserId()); // 直接推荐人id
        directFilters.put("certificationNumber",directPromotionNumber.getCertificationNumber() + 1); // 实名认证人数 + 1
        directFilters.put("directBronzeNumber",directPromotionNumber.getDirectBronzeNumber() + 1); // 直接铜牌人数 + 1
        //更新 推荐人表
        promotionNumberService.updatePromotionNumber(directFilters);

        //获取该用户间接推荐人 User 对象
        User indirectUser = userService.findUserByPhone(directUser.getRefereePhone());
        if (indirectUser == null){//如果对象为空证明没有间接推荐人，结束return
            return;
        }
        //获取间接推荐人的推荐人数表
        PromotionNumber indirectpromotionNumber = promotionNumberService.findPromotionNumberByUserId(indirectUser.getId());
        //修改其中的值
        Map<String, Object> indirectFilters = new HashMap<>();
        indirectFilters.put("userId",indirectpromotionNumber.getUserId()); // 间接推荐人id
        indirectFilters.put("certificationNumber",indirectpromotionNumber.getCertificationNumber() + 1); // 实名认证人数 + 1
        indirectFilters.put("indirectBronzeNumber",indirectpromotionNumber.getIndirectBronzeNumber() + 1); // 间接铜牌人数 + 1
        //更新 推荐人表
        promotionNumberService.updatePromotionNumber(indirectFilters);
    }

    /**
     * 查询 根据信用卡号 返回对象
     * @param cardNumber
     * @return
     */
    @Override
    public CreditCard findCreditCardByByCardNumber(String cardNumber){
        return creditCardMapper.findCreditCardByByCardNumber(cardNumber);
    }

    /**
     * 查询 根据用户id 返回用户所有信用卡
     * @param userId
     * @return
     */
    @Override
    public List<CreditCard> findCreditCardByUserIdList(String userId){
        return creditCardMapper.findCreditCardByUserIdList(userId);
    }


    /**
     * 更新  更新信用卡
     * @param filters
     */
    @Override
    public void updateCreditCard(Map<String, Object> filters){
        creditCardMapper.updateCreditCard(filters);
    }



    /**
     * 删除 根据信用卡号 删除
     * @param cardNumber
     */
    @Override
    public void deleteCreditCardByCardNumber(String cardNumber){
        //判断是否存在信用卡卡号
        CreditCard creditCard = creditCardMapper.findCreditCardByByCardNumber(cardNumber);
        if(creditCard == null){
            return;//信用卡卡号不存在
        }
        //删除 用户银行信息卡表中的数据
        Map<String,Object> filter = new HashMap<>();
        filter.put("cardId",creditCard.getId());//id
        filter.put("cardType",StatusSummary.CardType.CREDIT);//类型 信用卡
        UserBankInfo userBankInfo = userBankInfoService.findUserBankInfoByCardIdAndCardType(filter);
        userBankInfoService.deleteUserBankInfoById(userBankInfo.getId());
        //删除 信用卡中的信息
        creditCardMapper.deleteCreditCardByCardNumber(cardNumber);
    }
}
