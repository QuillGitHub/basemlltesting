package com.mll.data.testing.rates.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 14:05
 **/
@Table(name = "t_rates")
public class Rates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "grade_id")
    private String gradeId;

    private String name;

    private BigDecimal rates;

    private BigDecimal settlement;

    private Integer quota;

    private Integer integral;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRates() {
        return rates;
    }

    public void setRates(BigDecimal rates) {
        this.rates = rates;
    }

    public BigDecimal getSettlement() {
        return settlement;
    }

    public void setSettlement(BigDecimal settlement) {
        this.settlement = settlement;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
}
