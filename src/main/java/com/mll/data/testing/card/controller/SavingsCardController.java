package com.mll.data.testing.card.controller;

import com.mll.data.testing.card.entity.SavingsCard;
import com.mll.data.testing.card.entity.UserBankInfo;
import com.mll.data.testing.card.service.SavingsCardService;
import com.mll.data.testing.card.service.UserBankInfoService;
import com.mll.data.testing.card.vo.SavingsCardVO;
import com.mll.data.testing.share.StatusSummary;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/SavingsCard")
public class SavingsCardController {

    @Autowired
    private SavingsCardService savingsCardService;

    @Autowired
    private UserBankInfoService userBankInfoService;

    @PostMapping("/save")
    public String saveSavingsCard(SavingsCard savingsCard){
        if(savingsCardService.findSavingsCardByCardNumber(savingsCard.getCardNumber()) != null){//存储卡号不能重复
            return JSONUtil.assemble(Result.FAILURE,"保存失败1");//如果重复不保存
        }
        savingsCardService.saveSavingsCard(savingsCard);
        return JSONUtil.assemble(Result.SUCCESS,"保存成功");
    }

    @GetMapping("/findSavingsCardByCardNumber")
    public SavingsCard findSavingsCardByCardNumber(String cardNumber){
        return savingsCardService.findSavingsCardByCardNumber(cardNumber);
    }

    @GetMapping("/findSavingsCardByUserIdList")
    public String findSavingsCardByUserIdList(String userId){
        List<SavingsCard> list = savingsCardService.findSavingsCardByUserIdList(userId);
        return JSONUtil.assemble(Result.SUCCESS,list,"查询到该用户储蓄卡");
    }

    /**
     * 查询 根据用户id 储蓄卡卡号 返回某张储蓄卡基本信息
     * @param userId
     * @param cardNumber
     * @return
     */
    @GetMapping("/findSavingsCardVO")
    public String findSavingsCardVO(String userId,String cardNumber){
        List<SavingsCard> savingsCardList =savingsCardService.findSavingsCardByUserIdList(userId);
        SavingsCardVO savingsCardVO = new SavingsCardVO();
        for (SavingsCard s : savingsCardList){
            if(s.getCardNumber().equals(cardNumber)){
                BeanUtils.copyProperties(s,savingsCardVO);
                break;
            }
        }
        return JSONUtil.assemble(Result.SUCCESS,savingsCardVO,"查询到该储蓄卡信息");
    }


    /**
     * 删除 根据用户id 储蓄卡卡号 删除用户某张储蓄卡
     * @param userId
     * @param cardNumber
     * @return
     */
    @PostMapping("/deleteSavingsCardByCardNumber")
    public String deleteSavingsCardByCardNumber(@RequestParam(value = "userId", required = true) String userId,
                                                @RequestParam(value = "cardNumber", required = true) String cardNumber){
        //判断卡号是否存在
        if(savingsCardService.findSavingsCardByCardNumber(cardNumber) == null){
            return JSONUtil.assemble(Result.FAILURE,"删除储蓄卡失败1");//没有此储蓄卡
        }
        //获取该卡所有信息
        SavingsCard savingsCard = savingsCardService.findSavingsCardByCardNumber(cardNumber);
        Map<String, Object> userfilters = new HashMap<>();
        userfilters.put("cardId",savingsCard.getId());
        userfilters.put("cardType",StatusSummary.CardType.SAVINGS);
        //判断 该类型卡在 用户银行信息卡表中还有多少个
        Map<String, Object> filters = new HashMap<>();
        filters.put("userId",userId);
        filters.put("cardType", StatusSummary.CardType.SAVINGS);
        filters.put("status",StatusSummary.Authentication.SUCCESS);
        List<UserBankInfo> userBankInfoList = userBankInfoService.findUserBankInfoByUserIdAndCardTypeAndStatusList(filters);
        int i = 0;
        for(UserBankInfo u : userBankInfoList){
            i++;
        }
        if(i == 1 && (userBankInfoService.findUserBankInfoByCardIdAndCardType(userfilters).getStatus()==2)){
            return JSONUtil.assemble(Result.FAILURE,"删除储蓄卡失败2");//仅剩一张可用的储蓄卡不能删除
        }
        savingsCardService.deleteSavingsCardByCardNumber(cardNumber);
        return JSONUtil.assemble(Result.SUCCESS,"删除储蓄卡成功");
    }
}
