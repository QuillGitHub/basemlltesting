package com.mll.data.testing.user.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_user_info")
public class UserInfo {

    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    //用户id
    private String userId;

    //姓名
    private String fullName;

    //性别
    private Integer sex;

    //身份证号
    private String identityId;

    //注册时间
    private Date createTime;

    //直接上级
    private String directSuperior;

    //间接上级
    private String indirectSuperior;

    //登录次数
    private String loginCount;

    //登录ip
    private String loginIp;

    //积分
    private BigDecimal integral;

    //分润
    private BigDecimal shareBenefit;

    //最后一次登录时间
    private Date lastTime;

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDirectSuperior() {
        return directSuperior;
    }

    public void setDirectSuperior(String directSuperior) {
        this.directSuperior = directSuperior;
    }

    public String getIndirectSuperior() {
        return indirectSuperior;
    }

    public void setIndirectSuperior(String indirectSuperior) {
        this.indirectSuperior = indirectSuperior;
    }

    public String getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(String loginCount) {
        this.loginCount = loginCount;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public BigDecimal getShareBenefit() {
        return shareBenefit;
    }

    public void setShareBenefit(BigDecimal shareBenefit) {
        this.shareBenefit = shareBenefit;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}