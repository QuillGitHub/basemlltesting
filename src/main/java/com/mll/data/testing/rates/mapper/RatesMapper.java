package com.mll.data.testing.rates.mapper;

import com.mll.data.testing.rates.VO.RatesVO;
import com.mll.data.testing.rates.entity.Rates;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 14:05
 **/
@Repository
public interface RatesMapper extends BaseMapper<Rates>{

    @Select("select * from t_rates where grade_id = #{gradeId}")
    public List<RatesVO> findRatesByGradeId(String gradeId);
}
