package com.mll.data.testing.banner.VO;

/**
 * @author Yingjie Qi
 * @create 2018-05-08 15:12
 **/

public class BannerVO {
    private Integer playOrder;

    private String imgUrl;

    private String jumpPage;

    public Integer getPlayOrder() {
        return playOrder;
    }

    public void setPlayOrder(Integer playOrder) {
        this.playOrder = playOrder;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getJumpPage() {
        return jumpPage;
    }

    public void setJumpPage(String jumpPage) {
        this.jumpPage = jumpPage;
    }

    @Override
    public String toString() {
        return "BannerVO{" +
                "playOrder=" + playOrder +
                ", imgUrl='" + imgUrl + '\'' +
                ", jumpPage='" + jumpPage + '\'' +
                '}';
    }
}
