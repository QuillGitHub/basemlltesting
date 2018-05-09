package com.mll.data.testing.card.service.impl;

import com.mll.data.testing.card.entity.SavingsCard;
import com.mll.data.testing.card.entity.UserBankInfo;
import com.mll.data.testing.card.mapper.SavingsCardMapper;
import com.mll.data.testing.card.service.SavingsCardService;
import com.mll.data.testing.card.service.UserBankInfoService;
import com.mll.data.testing.share.StatusSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SavingsCardServiceImpl implements SavingsCardService {

    @Autowired
    private SavingsCardMapper savingsCardMapper;

    @Autowired
    private UserBankInfoService userBankInfoService;

    /**
     * 保存  用户的储蓄卡
     * @param savingsCard
     */
    @Override
    public void saveSavingsCard(SavingsCard savingsCard){
        //存储蓄卡号不能重复
        if(findSavingsCardByCardNumber(savingsCard.getCardNumber()) != null){
            return;//如果重复不保存
        }
        //保存到用户银行卡信息表
        UserBankInfo userBankInfo = new UserBankInfo();
        userBankInfo.setUserId(savingsCard.getUserId());
        userBankInfo.setCardType(StatusSummary.CardType.SAVINGS);//卡类型存储卡
        userBankInfo.setStatus(StatusSummary.Authentication.UNCERTIFIED);//未认证
        savingsCardMapper.insert(savingsCard);
        SavingsCard tepmSC = findSavingsCardByCardNumber(savingsCard.getCardNumber());
        userBankInfo.setCardId(tepmSC.getId());
        userBankInfoService.saveUserBankInfo(userBankInfo);//保存存储卡

    }

    /**
     * 查询 根据储蓄卡号 返回对象
     * @param cardNumber
     * @return
     */
    @Override
    public SavingsCard findSavingsCardByCardNumber(String cardNumber){
        return savingsCardMapper.findSavingsCardByCardNumber(cardNumber);
    }

    /**
     * 查询 根据用户id 返回所有储蓄卡
     * @param userId
     * @return
     */
    @Override
    public List<SavingsCard> findSavingsCardByUserIdList(String userId){
        return savingsCardMapper.findSavingsCardByUserIdList(userId);
    }

    /**
     * 删除 根据储蓄卡号 删除
     * @param cardNumber
     */
    @Override
    public void deleteSavingsCardByCardNumber(String cardNumber){
        //判断是否存在储蓄卡卡号
        SavingsCard savingsCard = savingsCardMapper.findSavingsCardByCardNumber(cardNumber);
        if(savingsCard == null){
            return;//储蓄卡卡号不存在结束
        }
        //删除 用户银行信息卡表中的数据
        Map<String,Object> filter = new HashMap<>();
        filter.put("cardId",savingsCard.getId());//id
        filter.put("cardType",StatusSummary.CardType.SAVINGS);//类型 信用卡
        UserBankInfo userBankInfo = userBankInfoService.findUserBankInfoByCardIdAndCardType(filter);
        userBankInfoService.deleteUserBankInfoById(userBankInfo.getId());
        //删除 用户储蓄卡表中的数据
        savingsCardMapper.deleteSavingsCardByCardNumber(cardNumber);
    }


}
