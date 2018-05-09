package com.mll.data.testing.card.controller;

import com.mll.data.testing.card.entity.CreditCard;
import com.mll.data.testing.card.entity.UserBankInfo;
import com.mll.data.testing.card.service.CreditCardService;
import com.mll.data.testing.card.service.UserBankInfoService;
import com.mll.data.testing.card.vo.CreditCardVO;
import com.mll.data.testing.share.StatusSummary;
import com.mll.data.testing.user.service.UserService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/CreditCard")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserBankInfoService userBankInfoService;


    @PostMapping("/save")
    public String saveCreditCard(CreditCard creditCard){
        if(creditCardService.findCreditCardByByCardNumber(creditCard.getCardNumber()) != null){//信用卡卡号不能重复
            return JSONUtil.assemble(Result.FAILURE,"保存信用卡失败1");//信用卡保存失败
        }
        creditCardService.saveCreditCard(creditCard);

        //修改用户登录状态
        Map<String,Object> userFilters = new HashMap<>();
        userFilters.put("id",creditCard.getUserId());
        userFilters.put("authentication", StatusSummary.Authentication.SUCCESS);
        userService.updateUser(userFilters);
        return JSONUtil.assemble(Result.SUCCESS,"保存信用卡成功");
    }

    @GetMapping("/findCreditCard")
    public CreditCard findCreditCardByByCardNumber(String cardNumber){
        return creditCardService.findCreditCardByByCardNumber(cardNumber);
    }

    @GetMapping("/findCreditCardByUserIdList")
    public String findCreditCardByUserIdList(String userId){
        List<CreditCard> list = creditCardService.findCreditCardByUserIdList(userId);
        return JSONUtil.assemble(Result.SUCCESS,list,"查询到信用卡");
    }


    @PostMapping("/saveNewCreditCard")
    public String saveNewCreditCard(@RequestParam(value ="userId", required = true) String userId,
                                    @RequestParam(value ="cardNumber", required = true) String cardNumber,
                                    @RequestParam(value ="affiliatedBank", required = true) String affiliatedBank,
                                    @RequestParam(value ="validityDate", required = false) String validityDate,
                                    @RequestParam(value ="cvn", required = false) String cvn,
                                    @RequestParam(value ="reservedPhoneNumber", required = false) String reservedPhoneNumber,
                                    @RequestParam(value ="bankCardQuota", required = false) Integer bankCardQuota,
                                    @RequestParam(value ="statementDate", required = false) String statementDate,
                                    @RequestParam(value ="repaymentDate", required = false) String repaymentDate){
        CreditCard creditCard = new CreditCard();
        creditCard.setUserId(userId);
        creditCard.setCardNumber(cardNumber);
        creditCard.setAffiliatedBank(affiliatedBank);
        creditCardService.saveCreditCard(creditCard);

        Map<String, Object> filters = new HashMap<>();
        filters.put("userId",userId);
        filters.put("cardNumber",cardNumber);
        filters.put("affiliatedBank",affiliatedBank);
        if(validityDate != null) {
            filters.put("validityDate", validityDate);
        }
        if(cvn != null) {
            filters.put("cvn", cvn);
        }
        if(repaymentDate != null) {
            filters.put("reservedPhoneNumber", reservedPhoneNumber);
        }
        if(bankCardQuota != null) {
            filters.put("bankCardQuota", bankCardQuota);
        }
        if(statementDate != null) {
            filters.put("statementDate", statementDate);
        }
        if(repaymentDate != null) {
            filters.put("repaymentDate", repaymentDate);
        }
        creditCardService.updateCreditCard(filters);
        return JSONUtil.assemble(Result.SUCCESS,"保存一张新的信用卡");
    }

    /**
     * 查询 根据用户id 信用卡卡号 返回某张信用卡基本信息
     * @param userId
     * @param cardNumber
     * @return
     */
    @GetMapping("/findCreditCardVO")
    public String findCreditCardVO(String userId,String cardNumber){
        List<CreditCard> cardByUserIdList =creditCardService.findCreditCardByUserIdList(userId);
        CreditCardVO creditCardVO = new CreditCardVO();
        for (CreditCard c : cardByUserIdList){
            if(c.getCardNumber().equals(cardNumber)){
                BeanUtils.copyProperties(c,creditCardVO);
                break;
            }
        }
        return JSONUtil.assemble(Result.SUCCESS,creditCardVO,"查询到该信用卡信息");
    }

    @PostMapping("/updateCreditCard")
    public String updateCreditCard(@RequestParam(value ="userId", required = true) String userId,
                                   @RequestParam(value ="cardNumber", required = true) String cardNumber,
                                   @RequestParam(value ="validityDate", required = false) String validityDate,
                                   @RequestParam(value ="cvn", required = false) String cvn,
                                   @RequestParam(value ="reservedPhoneNumber", required = false) String reservedPhoneNumber,
                                   @RequestParam(value ="bankCardQuota", required = false) Integer bankCardQuota,
                                   @RequestParam(value ="statementDate", required = false) String statementDate,
                                   @RequestParam(value ="repaymentDate", required = false) String repaymentDate
                                   ){
        //卡号必须存在，属于该用户
        CreditCard creditCard = creditCardService.findCreditCardByByCardNumber(cardNumber);
        if(creditCard == null){
            return JSONUtil.assemble(Result.FAILURE,"更新信用卡信息失败1"); // 该信用卡卡号不存在
        }
        if (!creditCard.getUserId().equals(userId)){
            return JSONUtil.assemble(Result.FAILURE,"更新信用卡信息失败2"); //该信用卡卡号不属于该用户
        }
        Map<String, Object> filters = new HashMap<>();
        filters.put("userId",userId);
        filters.put("cardNumber",cardNumber);
        if(validityDate != null) {
            filters.put("validityDate", validityDate);
        }
        if(cvn != null) {
            filters.put("cvn", cvn);
        }
        if(repaymentDate != null) {
            filters.put("reservedPhoneNumber", reservedPhoneNumber);
        }
        if(bankCardQuota != null) {
            filters.put("bankCardQuota", bankCardQuota);
        }
        if(statementDate != null) {
            filters.put("statementDate", statementDate);
        }
        if(repaymentDate != null) {
            filters.put("repaymentDate", repaymentDate);
        }
        creditCardService.updateCreditCard(filters);
        return  JSONUtil.assemble(Result.SUCCESS,"银行卡信息更新成功");
    }
    /**
     * 删除 根据用户id 信用卡卡号 删除一张信用卡
     * @param userId
     * @param cardNumber
     * @return
     */
    @PostMapping("/deleteCreditCardByCardNumber")
    public String deleteCreditCardByCardNumber(@RequestParam(value = "userId", required = true) String userId,
                                               @RequestParam(value = "cardNumber", required = true) String cardNumber){
        //判断是否存在信用卡
        if(creditCardService.findCreditCardByByCardNumber(cardNumber) == null){
            return JSONUtil.assemble(Result.FAILURE,"删除信用卡失败1");
        }
        //获取该卡所有信息
        CreditCard creditCard = creditCardService.findCreditCardByByCardNumber(cardNumber);
        Map<String, Object> userfilters = new HashMap<>();
        userfilters.put("cardId",creditCard.getId());
        userfilters.put("cardType",StatusSummary.CardType.CREDIT);
        //判断 该类型卡在 用户银行信息卡表中还有多少个
        Map<String, Object> filters = new HashMap<>();
        filters.put("userId",userId);
        filters.put("cardType", StatusSummary.CardType.CREDIT);
        filters.put("status",StatusSummary.Authentication.SUCCESS);
        List<UserBankInfo> userBankInfoList = userBankInfoService.findUserBankInfoByUserIdAndCardTypeAndStatusList(filters);
        int i = 0;
        for(UserBankInfo u : userBankInfoList){
            i++;
        }
        if(i == 1 && (userBankInfoService.findUserBankInfoByCardIdAndCardType(userfilters).getStatus()==2)){
            return JSONUtil.assemble(Result.FAILURE,"删除信用卡失败2");//仅剩一张可用的信用卡不能删除
        }
        creditCardService.deleteCreditCardByCardNumber(cardNumber);
        //删除 用户银行卡信息表中的信用卡信息
        return JSONUtil.assemble(Result.SUCCESS,"删除信用卡成功");
    }
}
