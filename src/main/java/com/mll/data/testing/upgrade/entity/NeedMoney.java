package com.mll.data.testing.upgrade.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "t_upgrade_type_money")
public class NeedMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String grade;

    private String abbreviation;

    private Integer upgrade;

    private BigDecimal money;

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
