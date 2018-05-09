package com.mll.data.testing.user.entity;


import javax.persistence.*;

@Table(name = "t_promotion_number")
public class PromotionNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "certification_number")
    private Integer certificationNumber;

    @Column(name = "direct_gold_number")
    private Integer directGoldNumber;

    @Column(name = "direct_silver_number")
    private Integer directSilverNumber;

    @Column(name = "direct_bronze_number")
    private Integer directBronzeNumber;

    @Column(name = "indirect_gold_number")
    private Integer indirectGoldNumber;

    @Column(name = "indirect_silver_number")
    private Integer indirectSilverNumber;

    @Column(name = "indirect_bronze_number")
    private Integer indirectBronzeNumber;

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