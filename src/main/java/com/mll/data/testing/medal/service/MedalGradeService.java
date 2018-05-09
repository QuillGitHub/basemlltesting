package com.mll.data.testing.medal.service;

import com.mll.data.testing.medal.entity.MedalGrade;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 11:26
 **/
public interface MedalGradeService {
    void saveMedalGrade(MedalGrade medalGrade);

    List<MedalGrade> findAll();

    MedalGrade findMedalGradeById(String id);

    MedalGrade findMedalGradeByGradeAbbreviation(String gradeAbbreviation);

    MedalGrade findMedalGradeByGrade(String grade);
}
