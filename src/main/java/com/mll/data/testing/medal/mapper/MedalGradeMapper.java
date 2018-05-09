package com.mll.data.testing.medal.mapper;

import com.mll.data.testing.medal.entity.MedalGrade;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedalGradeMapper extends BaseMapper<MedalGrade> {

    @Select("select * from t_medal_grade")
    public List<MedalGrade> findAll();

    @Select("select * from t_medal_grade where id = #{id}")
    public MedalGrade findMedalGradeById(String id);

    @Select("select * from t_medal_grade where grade_abbreviation = #{gradeAbbreviation}")
    public MedalGrade findMedalGradeByGradeAbbreviation(String gradeAbbreviation);

    @Select("select * from t_medal_grade where grade = #{grade}")
    public MedalGrade findMedalGradeByGrade(String grade);
}
