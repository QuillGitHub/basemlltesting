package com.mll.data.testing.user.service.impl;

import com.mll.data.testing.user.entity.PromotionNumber;
import com.mll.data.testing.user.mapper.PromotionNumberMapper;
import com.mll.data.testing.user.service.PromotionNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class PromotionNumberServiceImpl implements PromotionNumberService {

    @Autowired
    private PromotionNumberMapper promotionNumberMapper;

    /**
     * 保存 保存推广人数
     * @param promotionNumber
     */
    @Override
    public void savePromotionNumber(PromotionNumber promotionNumber){
        if(findPromotionNumberByUserId(promotionNumber.getUserId()) != null){
            return;//用户名重复不能保存
        }
        //保存推广人数的初始值（MySQL 默认值有时失效，写如下的方式，或者直接在实体类上赋值）
        promotionNumber.setCertificationNumber(0);
        promotionNumber.setDirectGoldNumber(0);
        promotionNumber.setDirectSilverNumber(0);
        promotionNumber.setDirectBronzeNumber(0);
        promotionNumber.setIndirectGoldNumber(0);
        promotionNumber.setIndirectSilverNumber(0);
        promotionNumber.setIndirectBronzeNumber(0);
        promotionNumberMapper.insert(promotionNumber);
    }

    /**
     * 查询 根据用户id 返回对象
     * @param userId
     * @return
     */
    @Override
    public PromotionNumber findPromotionNumberByUserId(String userId){
       return promotionNumberMapper.findPromotionNumberByUserId(userId);
    }

    /**
     * 更新 更新推荐人数表
     * @param filters
     */
    @Override
    public void updatePromotionNumber(Map<String, Object> filters){
        promotionNumberMapper.updatePromotionNumber(filters);
    }


}
