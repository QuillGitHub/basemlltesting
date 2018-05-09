package com.mll.data.testing.user.vo;

public class UserVO {

    private String id;

    //登录账号
    private String loginName;

    //手机号
    private String phone;

    //是否认证
    private Integer authentication;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }
}
