package com.mll.data.testing.rates.VO;

import java.math.BigDecimal;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 15:29
 **/
public class RatesVO {

    //支付通道名字
    private String name;

    //费率
    private BigDecimal rates;

    //结算
    private BigDecimal settlement;

    //额度
    private Integer quota;

    //有无积分
    private Integer integral;

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
