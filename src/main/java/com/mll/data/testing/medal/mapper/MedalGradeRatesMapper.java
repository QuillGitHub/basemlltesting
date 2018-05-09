/*
package com.mll.data.testing.medal.mapper;

import com.mll.data.testing.medal.entity.MedalGradeRates;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedalGradeRatesMapper extends BaseMapper<MedalGradeRates> {

    */
/**
     * 查询 根据简称返回对象，用于添加创建用户的时候，添加牌型id
     * @param gradeAbbreviation
     * @return
     *//*

    @Select("select * from t_medal_grade_rates where grade_abbreviation = #{gradeAbbreviation} ")
    public MedalGradeRates findMedalGradeRatesByAbbreviation(String gradeAbbreviation);

    */
/**
     * 查询 根据id 返回对象
     * @param id
     * @return
     *//*

    @Select("select * from t_medal_grade_rates where id = #{id} ")
    public MedalGradeRates findMedalGradeRatesById(String id);

    */
/**
     * 查询 返回所有牌型 的 费率信息
     * @return
     *//*

    @Select( "SELECT * FROM t_medal_grade_rates ")
    public List<MedalGradeRates> findAll();

}
*/
