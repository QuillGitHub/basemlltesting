package com.mll.data.testing.spread.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 图文推广类
 * @author Yingjie Qi
 * @create 2018-04-23 21:21
 **/
@Table(name = "t_graphic")
public class Graphic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user_id")
    private String userId;

    private String title;

    private String text;

    @Column(name = "img_one")
    private String imgOne;

    @Column(name = "img_two")
    private String imgTwo;

    @Column(name = "img_three")
    private String imgThree;

    @Column(name = "publish_time")
    private Date publishTime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgOne() {
        return imgOne;
    }

    public void setImgOne(String imgOne) {
        this.imgOne = imgOne;
    }

    public String getImgTwo() {
        return imgTwo;
    }

    public void setImgTwo(String imgTwo) {
        this.imgTwo = imgTwo;
    }

    public String getImgThree() {
        return imgThree;
    }

    public void setImgThree(String imgThree) {
        this.imgThree = imgThree;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
