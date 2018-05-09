package com.mll.data.testing.banner.entity;

import javax.persistence.*;

/**
 * @author Yingjie Qi
 * @create 2018-05-08 11:58
 **/

@Table(name = "t_banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "jump_page")
    private String jumpPage;

    @Column(name = "img_type")
    private Integer imgType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
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

    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }
}
