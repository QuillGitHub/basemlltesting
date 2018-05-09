package com.mll.data.testing.rates.service.impl;

import com.mll.data.testing.rates.VO.RatesVO;
import com.mll.data.testing.rates.entity.Rates;
import com.mll.data.testing.rates.mapper.RatesMapper;
import com.mll.data.testing.rates.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 14:08
 **/
@Service
@Transactional
public class RatesServiceImpl implements RatesService{

    @Autowired
    private RatesMapper ratesMapper;

    /**
     * 保存 保存一个费率对象
     * @param rates
     */
    @Override
    public void saveRates(Rates rates){
        ratesMapper.insert(rates);
    }

    /**
     * 查询 根据等级（牌型） 返回符合的所有对象
     * @param gradeId
     * @return
     */
    @Override
    public List<RatesVO> findRatesByGradeId(String gradeId){
        return ratesMapper.findRatesByGradeId(gradeId);
    }

}
