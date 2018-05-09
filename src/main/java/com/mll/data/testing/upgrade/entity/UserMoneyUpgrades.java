package com.mll.data.testing.upgrade.entity;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 18:53
 **/

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_user_money_upgrades")
public class UserMoneyUpgrades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "savings_card_id")
    private String savingsCardId;

    private BigDecimal money;

    @Column(name = "payment_time")
    private Date paymentTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSavingsCardId() {
        return savingsCardId;
    }

    public void setSavingsCardId(String savingsCardId) {
        this.savingsCardId = savingsCardId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}
