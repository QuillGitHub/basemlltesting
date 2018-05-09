package com.mll.data.testing.upgrade.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 20:10
 **/

@Table(name = "t_user_people_upgrades")
public class UserPeopleUpgrades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "recommended_number")
    private Integer recommendedNumber;

    @Column(name = "latest_time")
    private Date latestTime;

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

    public Integer getRecommendedNumber() {
        return recommendedNumber;
    }

    public void setRecommendedNumber(Integer recommendedNumber) {
        this.recommendedNumber = recommendedNumber;
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }
}
