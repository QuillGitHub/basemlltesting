package com.mll.data.testing.share;

public class StatusSummary {

    //未使用 用户牌子
    public static class MedalNum{

        //铜牌
        public static final int BRONZE = 1;

        //银牌
        public static final int SILVER = 2;

        //金牌
        public static final int GOLD = 3;
    }

    //认证
    public static class Authentication{

        //未认证
        public static final int UNCERTIFIED = 1;

        //认证成功
        public static final int SUCCESS = 2;

        //认证失败
        public static final int FAIL = 3;

    }

    //用户的账号是否锁定
    public static class Account{

        //正常
        public static final int NORMAL = 1;

        //锁定
        public static final int LOCKED = 2;

    }

    //用户隐私开关
    public static class PrivacSwitch {

        // 打开隐私显示
        public static final int OPEN = 1;

        // 关闭隐私显示
        public static final int CLOSE = 2;

    }

    //用户性别
    public static class Sex{

        //未知 0
        public static final int UNKNOW = 0;

        //男 1
        public static final int MALE = 1;

        //女 2
        public static final int FEMALE = 2;
    }

    //商户审核
    public static class ViaMerchant{

        //未审核
        public static final int UNAUDITED = 0;

        // 审核中
        public static final int AUDITING = 1;

        // 正常
        public static final int NORMAL = 2;

        // 已锁定
        public static final int LOCKED = 3;

        // 审核不通过
        public static final int REFUSE = 4;

    }

    //银行卡信息表 银行卡类型
    public static class CardType{

        //储蓄卡
        public static final int SAVINGS = 1;

        //信用卡
        public static final int CREDIT = 2;
    }

    //银行卡信息表 银行卡状态
    public static class CardStatus{

        //失败
        public static final int FAIL = 1;

        //成功
        public static final int SUCCESS = 2;
    }

    //照片审核(身份证照片，储蓄卡照片，信用卡照片 (一部分暂定，都会存在本服务器))
    public static class ViaPhoto{

        // 未审核
        public static final int UNAUDITED = 0;

        // 审核中
        public static final int AUDITING = 1;

        // 审核通过
        public static final int ADOPT = 2;

        // 审核不通过
        public static final int REFUSE = 3;
    }

    //升级方式（邀请人数升级 还是支付金额升级）
    public static class UpgradeMode {

        // 0 铜牌特殊状态
        public static final int NOTHING = 0;

        // 1 邀请人数升级
        public static final int PEOPLE = 1;

        // 2 付款升级
        public static final int MONEY = 2;

    }

    //升级到的
    public static class UpgradeTo{

        //铜牌升级到银牌
        public static final int BRONZEUPGRADESILVER = 1;

        //银牌升级到金牌
        public static final int SILVERUPGRADEGOLD = 2;

        //铜牌升级到金牌
        public static final int BRONZEUPGRADEGOLD = 3;
    }


    //  牌型 1 银牌  2 金牌
    public static class UpgradeMedal{

        // 银牌
        public static final int SILVER = 1;

        // 金牌
        public static final int GOLD = 2;
    }

    //  分润类型 1 升级  2费率差
    public static class ShareProfitType{

        //  升级
        public static final int UPGRADE = 1;

        //  费率差
        public static final int RATES = 2;
    }


}
