package com.mll.data.testing.card.service.impl;

import com.mll.data.testing.card.entity.UserBankInfo;
import com.mll.data.testing.card.mapper.UserBankInfoMapper;
import com.mll.data.testing.card.service.UserBankInfoService;
import com.mll.data.testing.share.StatusSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserBankInfoServiceImpl implements UserBankInfoService {

    @Autowired
    private UserBankInfoMapper userBankInfoMapper;

    /**
     * 保存 用户与银行卡信息
     * @param userBankInfo
     */
    @Override
    public void saveUserBankInfo(UserBankInfo userBankInfo){
        //存储银行卡 类型cardType (1 储蓄卡 2 信用卡)
        userBankInfo.setCardType(userBankInfo.getCardType() == 1? StatusSummary.CardType.SAVINGS :StatusSummary.CardType.CREDIT);
        //存储银行卡信息状态,暂时都为通过
        userBankInfo.setStatus(StatusSummary.CardStatus.SUCCESS);
        userBankInfoMapper.insert(userBankInfo);
    }

    /**
     * 查询 根据银行卡号 返回对象
     * @param cardId
     * @return
     */
    @Override
    public UserBankInfo findUserBankInfoByCardId(String cardId){
        return userBankInfoMapper.findUserBankInfoByCardId(cardId);
    }

    /**
     * 查询 根据用户id 返回用户所有银行卡信息（包含储蓄卡 信用卡）
     * @param userId
     * @return
     */
    @Override
    public List<UserBankInfo> findUserBankInfoByUserId(String userId){
        return userBankInfoMapper.findUserBankInfoByUserId(userId);
    }

    /**
     * 查询 根据银行卡号码 银行卡类型 返回对象
     * @param filter
     * @return
     */
    @Override
    public UserBankInfo findUserBankInfoByCardIdAndCardType(Map<String, Object> filter){
        return  userBankInfoMapper.findUserBankInfoByCardIdAndCardType(filter);
    }

    /**
     * 查询 根据id 返回对象
     * @param id
     * @return
     */
    @Override
    public UserBankInfo findUserBankInfoById(String id){
        return userBankInfoMapper.findUserBankInfoById(id);
    }

    /**
     * 查询 根据用户id  银行卡类型 卡状态 返回符合条件的所有卡
     * @param filters
     * @return
     */
    @Override
    public List<UserBankInfo> findUserBankInfoByUserIdAndCardTypeAndStatusList(Map<String, Object> filters){
        return userBankInfoMapper.findUserBankInfoByUserIdAndCardTypeAndStatusList(filters);
    }

    /**
     * 删除 根据id 删除银行卡
     * @param id
     */
    @Override
    public void deleteUserBankInfoById(String id){
        userBankInfoMapper.deleteUserBankInfoById(id);
    }

}
