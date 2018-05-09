package com.mll.data.testing.medal.entity;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 11:23
 **/
@Table(name = "t_medal_grade")
public class MedalGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String grade;

    @Column(name = "grade_abbreviation")
    private String gradeAbbreviation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGradeAbbreviation() {
        return gradeAbbreviation;
    }

    public void setGradeAbbreviation(String gradeAbbreviation) {
        this.gradeAbbreviation = gradeAbbreviation;
    }
}
