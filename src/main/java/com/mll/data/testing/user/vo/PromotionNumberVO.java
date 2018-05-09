package com.mll.data.testing.user.vo;

/**
 * @author Yingjie Qi
 * @create 2018-04-26 20:03
 **/

public class PromotionNumberVO {

    // 实名认证人数
    private Integer certificationNumber;

    // 直接金牌人数
    private Integer directGoldNumber;

    // 直接银牌人数
    private Integer directSilverNumber;

    // 直接铜牌人数
    private Integer directBronzeNumber;

    //间接金牌人数
    private Integer indirectGoldNumber;

    //间接银牌人数
    private Integer indirectSilverNumber;

    //间接铜牌人数
    private Integer indirectBronzeNumber;

    public Integer getCertificationNumber() {
        return certificationNumber;
    }

    public void setCertificationNumber(Integer certificationNumber) {
        this.certificationNumber = certificationNumber;
    }

    public Integer getDirectGoldNumber() {
        return directGoldNumber;
    }

    public void setDirectGoldNumber(Integer directGoldNumber) {
        this.directGoldNumber = directGoldNumber;
    }

    public Integer getDirectSilverNumber() {
        return directSilverNumber;
    }

    public void setDirectSilverNumber(Integer directSilverNumber) {
        this.directSilverNumber = directSilverNumber;
    }

    public Integer getDirectBronzeNumber() {
        return directBronzeNumber;
    }

    public void setDirectBronzeNumber(Integer directBronzeNumber) {
        this.directBronzeNumber = directBronzeNumber;
    }

    public Integer getIndirectGoldNumber() {
        return indirectGoldNumber;
    }

    public void setIndirectGoldNumber(Integer indirectGoldNumber) {
        this.indirectGoldNumber = indirectGoldNumber;
    }

    public Integer getIndirectSilverNumber() {
        return indirectSilverNumber;
    }

    public void setIndirectSilverNumber(Integer indirectSilverNumber) {
        this.indirectSilverNumber = indirectSilverNumber;
    }

    public Integer getIndirectBronzeNumber() {
        return indirectBronzeNumber;
    }

    public void setIndirectBronzeNumber(Integer indirectBronzeNumber) {
        this.indirectBronzeNumber = indirectBronzeNumber;
    }
}
