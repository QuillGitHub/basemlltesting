package com.mll.data.testing.profit.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Yingjie Qi
 * @create 2018-05-04 11:47
 **/

@Table(name = "t_share_profit")
public class ShareProfit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "share_profit_type")
    private Integer shareProfitType;

    @Column(name = "from_id")
    private String fromId;

    @Column(name = "trading_id")
    private String tradingId;

    private BigDecimal money;

    @Column(name = "share_profit_time")
    private Date shareProfitTime;

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

    public Integer getShareProfitType() {
        return shareProfitType;
    }

    public void setShareProfitType(Integer shareProfitType) {
        this.shareProfitType = shareProfitType;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getTradingId() {
        return tradingId;
    }

    public void setTradingId(String tradingId) {
        this.tradingId = tradingId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getShareProfitTime() {
        return shareProfitTime;
    }

    public void setShareProfitTime(Date shareProfitTime) {
        this.shareProfitTime = shareProfitTime;
    }
}
