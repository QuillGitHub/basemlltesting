package com.mll.data.testing.upgrade.entity;

import javax.persistence.*;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 17:59
 **/

@Table(name = "t_user_upgrade_mode")
public class UserUpgradeMode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "upgrade_type")
    private Integer upgradeType;

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

    public Integer getUpgradeType() {
        return upgradeType;
    }

    public void setUpgradeType(Integer upgradeType) {
        this.upgradeType = upgradeType;
    }
}
