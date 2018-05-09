package com.mll.data.testing.acct.service.impl;

import com.mll.data.testing.acct.entity.Merchant;
import com.mll.data.testing.acct.mapper.MerchantMapper;
import com.mll.data.testing.acct.service.MerchantService;
import com.mll.data.testing.share.StatusSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public void saveMerchant(Merchant merchant){
        if(merchantMapper.findMerchantByUserId(merchant.getUserId()) != null){
            return;//用户id 已经存在不能保存
        }
        merchant.setApplyTime(new Date());
        merchant.setStatus(StatusSummary.ViaMerchant.UNAUDITED);//未审核
        merchantMapper.insert(merchant);
    }

    @Override
    public Merchant findMerchantByUserId(String userId){
        return merchantMapper.findMerchantByUserId(userId);
    }
}
