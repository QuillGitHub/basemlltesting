package com.mll.data.testing.upgrade.VO;

/**
 * @author Yingjie Qi
 * @create 2018-04-28 15:48
 **/

public class UserUpgradeModeVO {

    private Integer referee;

    private Integer absent;

    public Integer getReferee() {
        return referee;
    }

    public void setReferee(Integer referee) {
        this.referee = referee;
    }

    public Integer getAbsent() {
        return absent;
    }

    public void setAbsent(Integer absent) {
        this.absent = absent;
    }

    @Override
    public String toString() {
        return "UserUpgradeModeVO{" +
                "referee=" + referee +
                ", absent=" + absent +
                '}';
    }
}
