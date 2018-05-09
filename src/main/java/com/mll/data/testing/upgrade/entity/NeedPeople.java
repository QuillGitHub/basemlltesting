package com.mll.data.testing.upgrade.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_upgrade_type_people")
public class NeedPeople {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String grade;

    private String abbreviation;

    private Integer upgrade;

    private Integer people;

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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Integer upgrade) {
        this.upgrade = upgrade;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }
}
