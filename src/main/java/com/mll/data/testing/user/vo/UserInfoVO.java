package com.mll.data.testing.user.vo;

public class UserInfoVO {

    //登录账号
    private String loginName;

    //手机号
    private String phone;

    //牌型
    private String medal;

    //直接上级（推荐人）
    private String directSuperior;

    //直接上级手机号（推荐人手机号）
    private String directSuperiorPhone;

    //头像
    private String portrait;

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

    public String getMedal() {
        return medal;
    }

    public void setMedal(String medal) {
        this.medal = medal;
    }

    public String getDirectSuperior() {
        return directSuperior;
    }

    public void setDirectSuperior(String directSuperior) {
        this.directSuperior = directSuperior;
    }

    public String getDirectSuperiorPhone() {
        return directSuperiorPhone;
    }

    public void setDirectSuperiorPhone(String directSuperiorPhone) {
        this.directSuperiorPhone = directSuperiorPhone;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}
