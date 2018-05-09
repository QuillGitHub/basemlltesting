package com.mll.data.testing.user.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String loginName;

    private String pwd;

    private String phone;

    //等级（普通、银牌、金牌）
    private String medal;

    //状态（是否锁定）
    private Integer status;

    //认证(没有认证需要认证详细信息)
    private Integer authentication;

    //隐私开关
    private Integer privacy;

    //推荐人手机号
    private String refereePhone;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMedal() {
        return medal;
    }

    public void setMedal(String medal) {
        this.medal = medal;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    public Integer getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Integer privacy) {
        this.privacy = privacy;
    }

    public String getRefereePhone() {
        return refereePhone;
    }

    public void setRefereePhone(String refereePhone) {
        this.refereePhone = refereePhone;
    }
}
