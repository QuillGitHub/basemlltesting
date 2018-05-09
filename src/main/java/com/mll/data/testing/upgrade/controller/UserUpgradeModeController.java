package com.mll.data.testing.upgrade.controller;

import com.alibaba.fastjson.JSONObject;
import com.mll.data.testing.card.entity.SavingsCard;
import com.mll.data.testing.card.entity.UserBankInfo;
import com.mll.data.testing.card.service.SavingsCardService;
import com.mll.data.testing.card.service.UserBankInfoService;
import com.mll.data.testing.medal.entity.MedalGrade;
import com.mll.data.testing.medal.service.MedalGradeService;
import com.mll.data.testing.profit.entity.ShareProfit;
import com.mll.data.testing.profit.service.ShareProfitService;
import com.mll.data.testing.share.StatusSummary;
import com.mll.data.testing.upgrade.VO.UserUpgradeModeVO;
import com.mll.data.testing.upgrade.entity.UserMoneyUpgrades;
import com.mll.data.testing.upgrade.entity.UserUpgradeMode;
import com.mll.data.testing.upgrade.service.NeedMoneyService;
import com.mll.data.testing.upgrade.service.NeedPeopleService;
import com.mll.data.testing.upgrade.service.UserMoneyUpgradesService;
import com.mll.data.testing.upgrade.service.UserUpgradeModeService;
import com.mll.data.testing.user.entity.PromotionNumber;
import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.service.PromotionNumberService;
import com.mll.data.testing.user.service.UserService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 18:06
 **/

@RestController
@RequestMapping("/UserUpgradeMode")
public class UserUpgradeModeController {

    @Autowired
    private UserUpgradeModeService userUpgradeModeService;

    @Autowired
    private UserService userService;

    @Autowired
    private MedalGradeService medalGradeService;

    @Autowired
    private NeedMoneyService needMoneyService;

    @Autowired
    private NeedPeopleService needPeopleService;

    @Autowired
    private PromotionNumberService promotionNumberService;

    @Autowired
    private SavingsCardService savingsCardService;

    @Autowired
    private UserBankInfoService userBankInfoService;

    @Autowired
    private UserMoneyUpgradesService userMoneyUpgradesService;

    @Autowired
    private ShareProfitService shareProfitService;

    @PostMapping("/save")
    public String saveUserUpgradeMode(UserUpgradeMode userUpgradeMode){
        userUpgradeModeService.saveUserUpgradeMode(userUpgradeMode);
        return JSONUtil.assemble(Result.SUCCESS,"保存用户升级方式");
    }

    @GetMapping("/findUserUpgradeModeByUserId")
    public String findUserUpgradeModeByUserId(String userId){
        UserUpgradeMode userUpgradeMode = userUpgradeModeService.findUserUpgradeModeByUserId(userId);
        if(userUpgradeMode == null){
            return JSONUtil.assemble(Result.SUCCESS,"没有该用户升级方式");
        }
        return JSONUtil.assemble(Result.SUCCESS,"查询到该用户使用的升级方式");
    }

    /**
     * 查询 根据用户id 返回用户所需升级方式
     * @param userId
     * @return
     */
    @GetMapping("/findUserNeedsToChooseByUserId")
    public String findUserNeedsToChooseByUserId(String userId){
        User user = userService.findUserByid(userId);
        MedalGrade medalGrade = medalGradeService.findMedalGradeById(user.getMedal());
        Map<String,Object> map = new HashMap<>();
        //判断牌型
        if(medalGradeService.findMedalGradeByGradeAbbreviation("TP").getId().equals(user.getMedal())){//如果铜牌
            //金额升级
            map.put("moneyBUS",needMoneyService.findNeedMoneyByUpgrade(1));
            map.put("moneyBUG",needMoneyService.findNeedMoneyByUpgrade(3));
            //人数升级
            map.put("peopleBUS",needPeopleService.findNeedPeopleByUpgrade(1));
            map.put("peopleBUG",needPeopleService.findNeedPeopleByUpgrade(3));
        }

        if(medalGradeService.findMedalGradeByGradeAbbreviation("YP").getId().equals(user.getMedal())){//如果银牌
            // 1 邀请人数
            if(userUpgradeModeService.findUserUpgradeModeByUserId(userId).getUpgradeType() == StatusSummary.UpgradeMode.PEOPLE){
                //金额升级
                map.put("moneyBUG",needMoneyService.findNeedMoneyByUpgrade(3));
                //人数升级
                map.put("peopleSUG",needPeopleService.findNeedPeopleByUpgrade(2));
            }
            // 2 金额升级
            if(userUpgradeModeService.findUserUpgradeModeByUserId(userId).getUpgradeType() == StatusSummary.UpgradeMode.MONEY){
                //金额升级
                map.put("moneySUG",needMoneyService.findNeedMoneyByUpgrade(2));
                //人数升级
                map.put("peopleBUG",needPeopleService.findNeedPeopleByUpgrade(3));
            }
        }
        return JSONUtil.assemble(Result.SUCCESS,map,"查找到该用户所需升级方式");
    }

    /**
     * 更新 根据用户id  更新对象
     * @param userId
     * @param type
     * @return
     */
    @PostMapping("/update")
    public String updateUserUpgradeMode(String userId,Integer type) {
        userUpgradeModeService.updateUserUpgradeMode(userId,type);
        return JSONUtil.assemble(Result.SUCCESS,"用户升级方式更新成功");
    }


    //用户升级，暂时只支持人数升级（用户id  升级类型（1人数，2金额） 升级到（1银牌，2金牌））
    //金额升级再换个地方
    @PostMapping("/upgradeMode")
    public String upgradeMode(@RequestParam( value = "userId", required = true) String userId,
                              @RequestParam( value = "upgradeType", required = true) Integer upgradeType,
                              @RequestParam( value = "medal", required = true) Integer medal,
                              @RequestParam( value = "cardNumber", required = false, defaultValue = "")String cardNumber){

        //保存用户升级类型
        if(userUpgradeModeService.findUserUpgradeModeByUserId(userId) == null){
            UserUpgradeMode userUpgradeMode = new UserUpgradeMode();
            userUpgradeMode.setUserId(userId);
            userUpgradeMode.setUpgradeType(StatusSummary.UpgradeMode.NOTHING);
            saveUserUpgradeMode(userUpgradeMode);
        }
        // 升级类型不等于1 不等于2
        if(upgradeType != StatusSummary.UpgradeMode.PEOPLE && upgradeType != StatusSummary.UpgradeMode.MONEY
                || medal != StatusSummary.UpgradeMedal.SILVER && medal != StatusSummary.UpgradeMedal.GOLD){
            return JSONUtil.assemble(Result.FAILURE,"升级失败1"); // 没有这种升级方式
        }

        // 查询 判断用户等级
        User user = userService.findUserByid(userId);// 获取用户信息
        MedalGrade medalGrade = medalGradeService.findMedalGradeById(user.getMedal());// 获取该用户的牌型对象
        if(medal == 1 && medalGrade.getGradeAbbreviation().equals("YP") ){ // 如果本身是银牌，还升级银牌报错
            return JSONUtil.assemble(Result.FAILURE,"升级失败2"); // 银牌不能升级银牌
        }

        // 金额升级方式
        if(upgradeType == StatusSummary.UpgradeMode.MONEY){ // 金额升级，卡号存在，所属用户是该id
            //return JSONUtil.assemble(Result.FAILURE,"暂时未开通");
            return upgradeModeMoney(userId,upgradeType,medal,cardNumber);
        }

        /**
         * 升级的各种情况
         */
        UserUpgradeModeVO userUpgradeModeVO = new UserUpgradeModeVO();

        if(medal == 1 && medalGrade.getGradeAbbreviation().equals("TP")){// 用户升级前是否是铜牌 升级银牌
            int num = promotionNumberService.findPromotionNumberByUserId(userId).getCertificationNumber();// 邀请人数 实名认证人数
            if(num >= needPeopleService.findNeedPeopleByUpgrade(1).getPeople()){//铜牌升级银牌所需人数

                //根据用户 推荐人手机号获取直接推荐人信息
                User directUser = userService.findUserByPhone(user.getRefereePhone());
                User indirectUser =null;
                if(directUser != null) {
                    indirectUser = userService.findUserByPhone(directUser.getRefereePhone());
                }
                //没有直接推荐人
                if(directUser == null || user.getRefereePhone() == null){ // 如果为空，就是没有直接推荐人
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("YP").getId());// 用户升级成功 改为银牌
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户升级类型（1人数，2金额）表更新
                    updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.PEOPLE);
                    return JSONUtil.assemble(Result.SUCCESS,"升级成功1");//无直接推荐人
                }

                //有直接推荐人，没有间接推荐人
                if(directUser != null && indirectUser == null){ // 直接推荐铜牌人数 -1 直接推荐银牌人数 +1
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("YP").getId());// 用户升级成功 改为银牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); //直接推荐人id
                    directFilters.put("directBronzeNumber",directPromotionNumber.getDirectBronzeNumber() - 1); // 直接推荐铜牌人数 -1
                    directFilters.put("directSilverNumber",directPromotionNumber.getDirectSilverNumber() + 1); // 直接推荐银牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户升级类型（1人数，2金额）表保存
                    updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.PEOPLE);
                    return JSONUtil.assemble(Result.SUCCESS,"升级成功2");//有直接推荐人 无间接推荐人
                }

                //有直接推荐人，有间接推荐人
                if(directUser != null && indirectUser != null){
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("YP").getId());// 用户升级成功 改为银牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); // 直接推荐人id
                    directFilters.put("directBronzeNumber",directPromotionNumber.getDirectBronzeNumber() - 1); // 直接推荐铜牌人数 -1
                    directFilters.put("directSilverNumber",directPromotionNumber.getDirectSilverNumber() + 1); // 直接推荐银牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);

                    //获取间接推荐人推荐表
                    PromotionNumber indirectPromotionNumber = promotionNumberService.findPromotionNumberByUserId(indirectUser.getId());
                    //修改其中的值
                    Map<String, Object> indirectFilters = new HashMap<>();
                    indirectFilters.put("userId",indirectPromotionNumber.getUserId()); // 间接推荐人id
                    indirectFilters.put("indirectBronzeNumber",indirectPromotionNumber.getIndirectBronzeNumber() - 1); // 间接推荐铜牌人数 -1
                    indirectFilters.put("indirectSilverNumber",indirectPromotionNumber.getIndirectSilverNumber() + 1); // 间接推荐银牌人数 +1
                    //更新间接推荐人推荐表
                    promotionNumberService.updatePromotionNumber(indirectFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户升级类型（1人数，2金额）表更新
                    updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.PEOPLE);
                    return JSONUtil.assemble(Result.SUCCESS,"升级成功3");//有直接推荐人 有间接推荐人
                }
            }else{
                userUpgradeModeVO.setReferee(num);
                userUpgradeModeVO.setAbsent(needPeopleService.findNeedPeopleByUpgrade(1).getPeople() - num);
                JSONObject obj = new JSONObject();
                obj.put("msg","升级失败3");
                obj.put("code","-1");
                obj.put("data",userUpgradeModeVO);
                return obj.toJSONString();

                /*userUpgradeModeVO.setReferee(num);
                userUpgradeModeVO.setAbsent(needPeopleService.findNeedPeopleByUpgrade(1).getPeople() - num);//缺少的人数
                return JSONUtil.assemble(Result.FAILURE,userUpgradeModeVO,"升级失败3");//推荐的人数不够*/
            }
        }else if(medal == 2 && medalGrade.getGradeAbbreviation().equals("YP")){ // 银牌 升 金牌
            int num = promotionNumberService.findPromotionNumberByUserId(userId).getCertificationNumber();// 邀请人数 实名认证人数
            if(num >= needPeopleService.findNeedPeopleByUpgrade(3).getPeople()){ // 邀请人数 大于9
                //根据用户 推荐人手机号获取直接推荐人信息
                User directUser = userService.findUserByPhone(user.getRefereePhone());
                User indirectUser =null;
                if(directUser != null) {
                    indirectUser = userService.findUserByPhone(directUser.getRefereePhone());
                }

                //没有直接推荐人
                if(directUser == null){ // 如果为空，就是没有直接推荐人
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户升级类型（1人数，2金额）表更新
                    updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.PEOPLE);
                    return JSONUtil.assemble(Result.SUCCESS,"升级成功1");//无推荐人 升级成功
                }

                //有直接推荐人，没有间接推荐人
                if(directUser != null && indirectUser == null){ // 直接推荐银牌人数 -1 直接推荐金牌人数 +1
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); //直接推荐人id
                    directFilters.put("directSilverNumber",directPromotionNumber.getDirectSilverNumber() - 1); // 直接推荐银牌人数 -1
                    directFilters.put("directGoldNumber",directPromotionNumber.getDirectGoldNumber() + 1); // 直接推荐金牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户升级类型（1人数，2金额）表更新
                    updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.PEOPLE);
                    return JSONUtil.assemble(Result.SUCCESS,"升级成功2");//有直接推荐人 无间接推荐人
                }

                //有直接推荐人，有间接推荐人
                if(directUser != null && indirectUser != null){
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); // 直接推荐人id
                    directFilters.put("directSilverNumber",directPromotionNumber.getDirectSilverNumber() - 1); // 直接推荐银牌人数 -1
                    directFilters.put("directGoldNumber",directPromotionNumber.getDirectGoldNumber() + 1); // 直接推荐金牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);

                    //获取间接推荐人推荐表
                    PromotionNumber indirectPromotionNumber = promotionNumberService.findPromotionNumberByUserId(indirectUser.getId());
                    //修改其中的值
                    Map<String, Object> indirectFilters = new HashMap<>();
                    indirectFilters.put("userId",indirectPromotionNumber.getUserId()); // 间接推荐人id
                    indirectFilters.put("indirectSilverNumber",indirectPromotionNumber.getIndirectSilverNumber() - 1); // 间接推荐银牌人数 -1
                    indirectFilters.put("indirectGoldNumber",indirectPromotionNumber.getIndirectGoldNumber() + 1); // 间接推荐金牌人数 +1
                    //更新间接推荐人推荐表
                    promotionNumberService.updatePromotionNumber(indirectFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户升级类型（1人数，2金额）表更新
                    updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.PEOPLE);
                    return JSONUtil.assemble(Result.SUCCESS,"升级成功3");//有直接推荐人 有间接推荐人
                }
            }else{
                Map map = new HashMap();
                userUpgradeModeVO.setReferee(num);
                userUpgradeModeVO.setAbsent(needPeopleService.findNeedPeopleByUpgrade(3).getPeople() - num);
                JSONObject obj = new JSONObject();
                obj.put("msg","升级失败3");
                obj.put("code","-1");
                obj.put("data",userUpgradeModeVO);
                return obj.toJSONString();
            }
        }else if(medal == 2 && medalGrade.getGradeAbbreviation().equals("TP")){ // 铜牌 升级 金牌
            int num = promotionNumberService.findPromotionNumberByUserId(userId).getCertificationNumber();// 邀请人数 实名认证人数
            if(num >= needPeopleService.findNeedPeopleByUpgrade(3).getPeople()) { // 邀请人数 大于9
                //根据用户 推荐人手机号获取直接推荐人信息
                User directUser = userService.findUserByPhone(user.getRefereePhone());
                User indirectUser =null;
                if(directUser != null) {
                    indirectUser = userService.findUserByPhone(directUser.getRefereePhone());
                }

                //没有直接推荐人
                if(directUser == null){ // 如果为空，就是没有直接推荐人
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户升级类型（1人数，2金额）表更新
                    updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.PEOPLE);
                    return JSONUtil.assemble(Result.SUCCESS,"升级成功1");//无推荐人 升级成功
                }

                //有直接推荐人，没有间接推荐人
                if(directUser != null && indirectUser == null){ // 直接推荐银牌人数 -1 直接推荐金牌人数 +1
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); //直接推荐人id
                    directFilters.put("directBronzeNumber",directPromotionNumber.getDirectBronzeNumber() - 1); // 直接推荐铜牌人数 -1
                    directFilters.put("directGoldNumber",directPromotionNumber.getDirectGoldNumber() + 1); // 直接推荐金牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户升级类型（1人数，2金额）表更新
                    updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.PEOPLE);
                    return JSONUtil.assemble(Result.SUCCESS,"升级成功2");//有直接推荐人 无间接推荐人
                }

                //有直接推荐人，有间接推荐人
                if(directUser != null && indirectUser != null){
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); // 直接推荐人id
                    directFilters.put("directBronzeNumber",directPromotionNumber.getDirectBronzeNumber() - 1); // 直接推荐铜牌人数 -1
                    directFilters.put("directGoldNumber",directPromotionNumber.getDirectGoldNumber() + 1); // 直接推荐金牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);

                    //获取间接推荐人推荐表
                    PromotionNumber indirectPromotionNumber = promotionNumberService.findPromotionNumberByUserId(indirectUser.getId());
                    //修改其中的值
                    Map<String, Object> indirectFilters = new HashMap<>();
                    indirectFilters.put("userId",indirectPromotionNumber.getUserId()); // 间接推荐人id
                    indirectFilters.put("indirectBronzeNumber",indirectPromotionNumber.getIndirectBronzeNumber() - 1); // 间接推荐铜牌人数 -1
                    indirectFilters.put("indirectGoldNumber",indirectPromotionNumber.getIndirectGoldNumber() + 1); // 间接推荐金牌人数 +1
                    //更新间接推荐人推荐表
                    promotionNumberService.updatePromotionNumber(indirectFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户升级类型（1人数，2金额）表更新
                    updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.PEOPLE);
                    return JSONUtil.assemble(Result.SUCCESS,"升级成功3");//有直接推荐人 有间接推荐人
                }

            }else{
                userUpgradeModeVO.setReferee(num);
                userUpgradeModeVO.setAbsent(needPeopleService.findNeedPeopleByUpgrade(3).getPeople() - num);
                JSONObject obj = new JSONObject();
                obj.put("msg","升级失败3");
                obj.put("code","-1");
                obj.put("data",userUpgradeModeVO);
                return obj.toJSONString();
                /*userUpgradeModeVO.setReferee(num);
                userUpgradeModeVO.setAbsent(needPeopleService.findNeedPeopleByUpgrade(2).getPeople() - num);//缺少的人数
                return JSONUtil.assemble(Result.FAILURE,userUpgradeModeVO,"升级失败3");//推荐的人数不够*/
            }
        }

        return JSONUtil.assemble(Result.FAILURE,"升级失败4");//已经是金牌
    }


    /**
     * 升级 金额升级方式
     * @param userId
     * @param upgradeType
     * @param medal
     * @param cardNumber
     * @return
     */
    //用户升级，暂时只支持人数升级（用户id  升级类型（1人数，2金额） 升级到（1银牌，2金牌））
    public String upgradeModeMoney(@RequestParam( value = "userId", required = true) String userId,
                                   @RequestParam( value = "upgradeType", required = true) Integer upgradeType,
                                   @RequestParam( value = "medal", required = true) Integer medal,
                                   @RequestParam( value = "cardNumber", required = true, defaultValue = "")String cardNumber){

        //判断 储蓄卡是否属于该用户
        SavingsCard savingsCard = savingsCardService.findSavingsCardByCardNumber(cardNumber);
        if(!userId.equals(savingsCard == null ? "" : savingsCard.getUserId())){
            return JSONUtil.assemble(Result.FAILURE,"使用金额升级失败1"); // 该用户没有这个卡
        }

        //判断 储蓄卡的认证状态是否为 已认证
        UserBankInfo userBankInfo =userBankInfoService.findUserBankInfoByCardId(savingsCard.getId());
        if(userBankInfo.getStatus() == StatusSummary.CardStatus.FAIL){
            return JSONUtil.assemble(Result.FAILURE,"使用金额升级失败2"); // 该用户此卡未认证
        }

        //查询账号现在的牌型
        User user = userService.findUserByid(userId); // 升级用户对象
        MedalGrade medalGrade = medalGradeService.findMedalGradeById(user.getMedal());// 获取该用户的牌型对象

        if(medal == 1 && medalGrade.getGradeAbbreviation().equals("TP")){ // 铜牌 升 银牌
            //return JSONUtil.assemble(Result.SUCCESS,"使用金额升级成功1");
            if(true){ // 储蓄卡支付成功
                // 保存用户金额升级记录
                UserMoneyUpgrades userMoneyUpgrades = new UserMoneyUpgrades();
                userMoneyUpgrades.setUserId(userId); // 用户id
                userMoneyUpgrades.setSavingsCardId(savingsCard.getId()); // 用户储蓄卡id
                userMoneyUpgrades.setMoney(needMoneyService.findNeedMoneyByUpgrade(1).getMoney());//支付金额
                userMoneyUpgradesService.saveUserMoneyUpgrades(userMoneyUpgrades);
                // 用户升级类型（1人数，2金额）表更新
                updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.MONEY);
                // 用户分润
                // 获取该用户的金额升级记录对象
                UserMoneyUpgrades userMoneyUpgradesTemp = userMoneyUpgradesService.findUserMoneyUpgradesByUserIdMoney(userId,
                        needMoneyService.findNeedMoneyByUpgrade(1).getMoney());
                // 更新推荐人表
                //根据用户 推荐人手机号获取直接推荐人信息
                User directUser = userService.findUserByPhone(user.getRefereePhone());
                User indirectUser =null;
                 if(directUser != null) {
                    indirectUser = userService.findUserByPhone(directUser.getRefereePhone());
                }
                if(directUser == null || user.getRefereePhone() == null){ // 如果为空，就是没有直接推荐人
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("YP").getId());// 用户升级成功 改为银牌
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    return JSONUtil.assemble(Result.SUCCESS,"使用金额升级成功1");//无直接推荐人
                }
                //有直接推荐人，没有间接推荐人
                if(directUser != null && indirectUser == null){ // 直接推荐铜牌人数 -1 直接推荐银牌人数 +1
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("YP").getId());// 用户升级成功 改为银牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); //直接推荐人id
                    directFilters.put("directBronzeNumber",directPromotionNumber.getDirectBronzeNumber() - 1); // 直接推荐铜牌人数 -1
                    directFilters.put("directSilverNumber",directPromotionNumber.getDirectSilverNumber() + 1); // 直接推荐银牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户分润表 直接上级
                    ShareProfit directUserShareProfit = new ShareProfit();
                    directUserShareProfit.setUserId(directUser.getId());//直接上级用户id
                    //分润类型
                    directUserShareProfit.setShareProfitType(StatusSummary.ShareProfitType.UPGRADE);
                    //来自用户id
                    directUserShareProfit.setFromId(userId);
                    //交易id 升级类型
                    directUserShareProfit.setTradingId(userMoneyUpgradesTemp.getId());
                    //分润值计算(暂时固定 3 )
                    directUserShareProfit.setMoney(new BigDecimal(3));
                    // 保存 分润信息
                    shareProfitService.saveShareProfit(directUserShareProfit);
                    return JSONUtil.assemble(Result.SUCCESS,"使用金额升级成功2");//有直接推荐人 无间接推荐人
                }
                //有直接推荐人，有间接推荐人
                if(directUser != null && indirectUser != null){
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("YP").getId());// 用户升级成功 改为银牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); // 直接推荐人id
                    directFilters.put("directBronzeNumber",directPromotionNumber.getDirectBronzeNumber() - 1); // 直接推荐铜牌人数 -1
                    directFilters.put("directSilverNumber",directPromotionNumber.getDirectSilverNumber() + 1); // 直接推荐银牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);

                    //获取间接推荐人推荐表
                    PromotionNumber indirectPromotionNumber = promotionNumberService.findPromotionNumberByUserId(indirectUser.getId());
                    //修改其中的值
                    Map<String, Object> indirectFilters = new HashMap<>();
                    indirectFilters.put("userId",indirectPromotionNumber.getUserId()); // 间接推荐人id
                    indirectFilters.put("indirectBronzeNumber",indirectPromotionNumber.getIndirectBronzeNumber() - 1); // 间接推荐铜牌人数 -1
                    indirectFilters.put("indirectSilverNumber",indirectPromotionNumber.getIndirectSilverNumber() + 1); // 间接推荐银牌人数 +1
                    //更新间接推荐人推荐表
                    promotionNumberService.updatePromotionNumber(indirectFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户分润表 直接上级
                    ShareProfit directUserShareProfit = new ShareProfit();
                    directUserShareProfit.setUserId(directUser.getId());//直接上级用户id
                    //分润类型
                    directUserShareProfit.setShareProfitType(StatusSummary.ShareProfitType.UPGRADE);
                    //来自用户id
                    directUserShareProfit.setFromId(userId);
                    //交易id 升级类型
                    directUserShareProfit.setTradingId(userMoneyUpgradesTemp.getId());
                    //分润值计算(暂时固定 3 )
                    directUserShareProfit.setMoney(new BigDecimal(3));
                    // 保存 直接上级分润信息
                    shareProfitService.saveShareProfit(directUserShareProfit);
                    //用户分润表 间接上级
                    ShareProfit indirectUserShareProfit = new ShareProfit();
                    indirectUserShareProfit.setUserId(indirectUser.getId());// 间接上级用户id
                    //分润类型
                    indirectUserShareProfit.setShareProfitType(StatusSummary.ShareProfitType.UPGRADE);
                    //来自用户id
                    indirectUserShareProfit.setFromId(userId);
                    //交易id 升级类型
                    indirectUserShareProfit.setTradingId(userMoneyUpgradesTemp.getId());
                    //分润值计算(暂时固定 3 )
                    indirectUserShareProfit.setMoney(new BigDecimal(3));
                    // 保存 简介上级分润信息
                    shareProfitService.saveShareProfit(indirectUserShareProfit);
                    return JSONUtil.assemble(Result.SUCCESS,"使用金额升级成功3");//有直接推荐人 有间接推荐人
                }
            }else {
                return JSONUtil.assemble(Result.FAILURE,"使用金额升级失败3"); // 储蓄卡支付失败
            }
        }else if (medal == 2 && medalGrade.getGradeAbbreviation().equals("YP") &&
                (userUpgradeModeService.findUserUpgradeModeByUserId(userId).getUpgradeType() ==
                        StatusSummary.UpgradeMode.MONEY)) { // 银牌 升 金牌 (必须是金额升级方式)
            // 储蓄卡 支付成功
            if(true){
                // 保存用户金额升级记录
                UserMoneyUpgrades userMoneyUpgrades = new UserMoneyUpgrades();
                userMoneyUpgrades.setUserId(userId); // 用户id
                userMoneyUpgrades.setSavingsCardId(savingsCard.getId()); // 用户储蓄卡id
                userMoneyUpgrades.setMoney(needMoneyService.findNeedMoneyByUpgrade(2).getMoney());//支付金额
                userMoneyUpgradesService.saveUserMoneyUpgrades(userMoneyUpgrades);
                // 用户升级类型（1人数，2金额）表更新
                updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.MONEY);
                // 用户分润
                // 获取该用户的金额升级记录对象
                UserMoneyUpgrades userMoneyUpgradesTemp = userMoneyUpgradesService.findUserMoneyUpgradesByUserIdMoney(userId,
                        needMoneyService.findNeedMoneyByUpgrade(2).getMoney());
                // 更新推荐人表
                //根据用户 推荐人手机号获取直接推荐人信息
                User directUser = userService.findUserByPhone(user.getRefereePhone());
                User indirectUser =null;
                if(directUser != null) {
                    indirectUser = userService.findUserByPhone(directUser.getRefereePhone());
                }
                //没有直接推荐人
                if(directUser == null){ // 如果为空，就是没有直接推荐人
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    return JSONUtil.assemble(Result.SUCCESS,"使用金额升级成功1");//无推荐人 升级成功
                }
                //有直接推荐人，没有间接推荐人
                if(directUser != null && indirectUser == null){ // 直接推荐银牌人数 -1 直接推荐金牌人数 +1
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); //直接推荐人id
                    directFilters.put("directSilverNumber",directPromotionNumber.getDirectSilverNumber() - 1); // 直接推荐银牌人数 -1
                    directFilters.put("directGoldNumber",directPromotionNumber.getDirectGoldNumber() + 1); // 直接推荐金牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户分润表 直接上级
                    ShareProfit directUserShareProfit = new ShareProfit();
                    directUserShareProfit.setUserId(directUser.getId());//直接上级用户id
                    //分润类型
                    directUserShareProfit.setShareProfitType(StatusSummary.ShareProfitType.UPGRADE);
                    //来自用户id
                    directUserShareProfit.setFromId(userId);
                    //交易id 升级类型
                    directUserShareProfit.setTradingId(userMoneyUpgradesTemp.getId());
                    //分润值计算(暂时固定 30 )
                    directUserShareProfit.setMoney(new BigDecimal(30));
                    // 保存 直接上级分润信息
                    shareProfitService.saveShareProfit(directUserShareProfit);
                    return JSONUtil.assemble(Result.SUCCESS,"使用金额升级成功2");//有直接推荐人 无间接推荐人
                }
                //有直接推荐人，有间接推荐人
                if(directUser != null && indirectUser != null) {
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId", directPromotionNumber.getUserId()); // 直接推荐人id
                    directFilters.put("directSilverNumber", directPromotionNumber.getDirectSilverNumber() - 1); // 直接推荐银牌人数 -1
                    directFilters.put("directGoldNumber", directPromotionNumber.getDirectGoldNumber() + 1); // 直接推荐金牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);

                    //获取间接推荐人推荐表
                    PromotionNumber indirectPromotionNumber = promotionNumberService.findPromotionNumberByUserId(indirectUser.getId());
                    //修改其中的值
                    Map<String, Object> indirectFilters = new HashMap<>();
                    indirectFilters.put("userId", indirectPromotionNumber.getUserId()); // 间接推荐人id
                    indirectFilters.put("indirectSilverNumber", indirectPromotionNumber.getIndirectSilverNumber() - 1); // 间接推荐银牌人数 -1
                    indirectFilters.put("indirectGoldNumber", indirectPromotionNumber.getIndirectGoldNumber() + 1); // 间接推荐金牌人数 +1
                    //更新间接推荐人推荐表
                    promotionNumberService.updatePromotionNumber(indirectFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id", user.getId());
                    userFilters.put("medal", user.getMedal());
                    userService.updateUser(userFilters);
                    //用户分润表 直接上级
                    ShareProfit directUserShareProfit = new ShareProfit();
                    directUserShareProfit.setUserId(directUser.getId());//直接上级用户id
                    //分润类型
                    directUserShareProfit.setShareProfitType(StatusSummary.ShareProfitType.UPGRADE);
                    //来自用户id
                    directUserShareProfit.setFromId(userId);
                    //交易id 升级类型
                    directUserShareProfit.setTradingId(userMoneyUpgradesTemp.getId());
                    //分润值计算(暂时固定 30 )
                    directUserShareProfit.setMoney(new BigDecimal(30));
                    // 保存 直接上级分润信息
                    shareProfitService.saveShareProfit(directUserShareProfit);
                    //用户分润表 间接上级
                    ShareProfit indirectUserShareProfit = new ShareProfit();
                    indirectUserShareProfit.setUserId(indirectUser.getId());// 间接上级用户id
                    //分润类型
                    indirectUserShareProfit.setShareProfitType(StatusSummary.ShareProfitType.UPGRADE);
                    //来自用户id
                    indirectUserShareProfit.setFromId(userId);
                    //交易id 升级类型
                    indirectUserShareProfit.setTradingId(userMoneyUpgradesTemp.getId());
                    //分润值计算(暂时固定 30 )
                    indirectUserShareProfit.setMoney(new BigDecimal(30));
                    // 保存 简介上级分润信息
                    shareProfitService.saveShareProfit(indirectUserShareProfit);
                    return JSONUtil.assemble(Result.SUCCESS,"使用金额升级成功3");//有直接推荐人 有间接推荐人
                }
            }else{
                return JSONUtil.assemble(Result.FAILURE,"使用金额升级失败3"); // 储蓄卡支付失败
            }
        }else if (medal == 2 && medalGrade.getGradeAbbreviation().equals("TP") ||
                (userUpgradeModeService.findUserUpgradeModeByUserId(userId)).getUpgradeType() ==
                        StatusSummary.UpgradeMode.PEOPLE) { // 铜牌 升 金牌
            // 储蓄卡 支付成功
            if(true){
                // 保存用户金额升级记录
                UserMoneyUpgrades userMoneyUpgrades = new UserMoneyUpgrades();
                userMoneyUpgrades.setUserId(userId); // 用户id
                userMoneyUpgrades.setSavingsCardId(savingsCard.getId()); // 用户储蓄卡id
                userMoneyUpgrades.setMoney(needMoneyService.findNeedMoneyByUpgrade(3).getMoney());//支付金额
                userMoneyUpgradesService.saveUserMoneyUpgrades(userMoneyUpgrades);
                // 用户升级类型（1人数，2金额）表更新
                updateUserUpgradeMode(userId,StatusSummary.UpgradeMode.MONEY);
                // 用户分润
                // 获取该用户的金额升级记录对象
                UserMoneyUpgrades userMoneyUpgradesTemp = userMoneyUpgradesService.findUserMoneyUpgradesByUserIdMoney(userId,
                        needMoneyService.findNeedMoneyByUpgrade(3).getMoney());
                // 更新推荐人表
                //根据用户 推荐人手机号获取直接推荐人信息
                User directUser = userService.findUserByPhone(user.getRefereePhone());
                User indirectUser =null;
                if(directUser != null) {
                    indirectUser = userService.findUserByPhone(directUser.getRefereePhone());
                }
                //没有直接推荐人
                if(directUser == null){ // 如果为空，就是没有直接推荐人
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    return JSONUtil.assemble(Result.SUCCESS,"使用金额升级成功1");//无推荐人 升级成功
                }

                //有直接推荐人，没有间接推荐人
                if(directUser != null && indirectUser == null){ // 直接推荐银牌人数 -1 直接推荐金牌人数 +1
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); //直接推荐人id
                    directFilters.put("directBronzeNumber",directPromotionNumber.getDirectBronzeNumber() - 1); // 直接推荐铜牌人数 -1
                    directFilters.put("directGoldNumber",directPromotionNumber.getDirectGoldNumber() + 1); // 直接推荐金牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户分润表 直接上级
                    ShareProfit directUserShareProfit = new ShareProfit();
                    directUserShareProfit.setUserId(directUser.getId());//直接上级用户id
                    //分润类型
                    directUserShareProfit.setShareProfitType(StatusSummary.ShareProfitType.UPGRADE);
                    //来自用户id
                    directUserShareProfit.setFromId(userId);
                    //交易id 升级类型
                    directUserShareProfit.setTradingId(userMoneyUpgradesTemp.getId());
                    //分润值计算(暂时固定 33 )
                    directUserShareProfit.setMoney(new BigDecimal(33));
                    // 保存 直接上级分润信息
                    shareProfitService.saveShareProfit(directUserShareProfit);
                    return JSONUtil.assemble(Result.SUCCESS,"使用金额升级成功2");//有直接推荐人 无间接推荐人
                }

                //有直接推荐人，有间接推荐人
                if(directUser != null && indirectUser != null){
                    user.setMedal(medalGradeService.findMedalGradeByGradeAbbreviation("JP").getId());// 升级成功 改为金牌
                    //获取直接推荐人推荐表
                    PromotionNumber directPromotionNumber = promotionNumberService.findPromotionNumberByUserId(directUser.getId());
                    //修改其中的值
                    Map<String, Object> directFilters = new HashMap<>();
                    directFilters.put("userId",directPromotionNumber.getUserId()); // 直接推荐人id
                    directFilters.put("directBronzeNumber",directPromotionNumber.getDirectBronzeNumber() - 1); // 直接推荐铜牌人数 -1
                    directFilters.put("directGoldNumber",directPromotionNumber.getDirectGoldNumber() + 1); // 直接推荐金牌人数 +1
                    //更新 直接推荐人表
                    promotionNumberService.updatePromotionNumber(directFilters);

                    //获取间接推荐人推荐表
                    PromotionNumber indirectPromotionNumber = promotionNumberService.findPromotionNumberByUserId(indirectUser.getId());
                    //修改其中的值
                    Map<String, Object> indirectFilters = new HashMap<>();
                    indirectFilters.put("userId",indirectPromotionNumber.getUserId()); // 间接推荐人id
                    indirectFilters.put("indirectBronzeNumber",indirectPromotionNumber.getIndirectBronzeNumber() - 1); // 间接推荐铜牌人数 -1
                    indirectFilters.put("indirectGoldNumber",indirectPromotionNumber.getIndirectGoldNumber() + 1); // 间接推荐金牌人数 +1
                    //更新间接推荐人推荐表
                    promotionNumberService.updatePromotionNumber(indirectFilters);
                    //用户更新升级牌型
                    Map<String, Object> userFilters = new HashMap<>();
                    userFilters.put("id",user.getId());
                    userFilters.put("medal",user.getMedal());
                    userService.updateUser(userFilters);
                    //用户分润表 直接上级
                    ShareProfit directUserShareProfit = new ShareProfit();
                    directUserShareProfit.setUserId(directUser.getId());//直接上级用户id
                    //分润类型
                    directUserShareProfit.setShareProfitType(StatusSummary.ShareProfitType.UPGRADE);
                    //来自用户id
                    directUserShareProfit.setFromId(userId);
                    //交易id 升级类型
                    directUserShareProfit.setTradingId(userMoneyUpgradesTemp.getId());
                    //分润值计算(暂时固定 33 )
                    directUserShareProfit.setMoney(new BigDecimal(33));
                    // 保存 直接上级分润信息
                    shareProfitService.saveShareProfit(directUserShareProfit);
                    //用户分润表 间接上级
                    ShareProfit indirectUserShareProfit = new ShareProfit();
                    indirectUserShareProfit.setUserId(indirectUser.getId());// 间接上级用户id
                    //分润类型
                    indirectUserShareProfit.setShareProfitType(StatusSummary.ShareProfitType.UPGRADE);
                    //来自用户id
                    indirectUserShareProfit.setFromId(userId);
                    //交易id 升级类型
                    indirectUserShareProfit.setTradingId(userMoneyUpgradesTemp.getId());
                    //分润值计算(暂时固定 33 )
                    indirectUserShareProfit.setMoney(new BigDecimal(33));
                    // 保存 简介上级分润信息
                    shareProfitService.saveShareProfit(indirectUserShareProfit);
                    return JSONUtil.assemble(Result.SUCCESS,"使用金额升级成功3");//有直接推荐人 有间接推荐人
                }
            }else{
                return JSONUtil.assemble(Result.FAILURE,"使用金额升级失败3"); // 储蓄卡支付失败
            }
        }
        return JSONUtil.assemble(Result.FAILURE,"使用了金额升级失败4"); // 已经是金牌
    }

}
