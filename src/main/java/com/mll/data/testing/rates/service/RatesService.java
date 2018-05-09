package com.mll.data.testing.rates.service;

import com.mll.data.testing.rates.VO.RatesVO;
import com.mll.data.testing.rates.entity.Rates;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 14:07
 **/
public interface RatesService {
    void saveRates(Rates rates);

    List<RatesVO> findRatesByGradeId(String gradeId);
}
