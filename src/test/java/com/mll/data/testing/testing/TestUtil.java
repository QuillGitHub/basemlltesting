package com.mll.data.testing.testing;


import com.mll.data.testing.card.controller.CreditCardController;
import com.mll.data.testing.card.controller.SavingsCardController;
import com.mll.data.testing.card.entity.CreditCard;
import com.mll.data.testing.card.entity.SavingsCard;
import com.mll.data.testing.card.service.CreditCardService;
import com.mll.data.testing.card.service.SavingsCardService;
import com.mll.data.testing.medal.entity.MedalGrade;
import com.mll.data.testing.medal.service.MedalGradeService;
import com.mll.data.testing.user.controller.UserController;
import com.mll.data.testing.user.entity.User;
import com.mll.data.testing.user.entity.UserInfo;
import com.mll.data.testing.user.service.UserInfoService;
import com.mll.data.testing.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUtil {

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SavingsCardService savingsCardService;

    @Autowired
    private SavingsCardController savingsCardController;

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private CreditCardController creditCardController;

    @Autowired
    private MedalGradeService medalGradeService;

    @Test
    public void find(){
    }


    /**
     * 从创建账号，认证信息，认证储蓄卡，认证信用卡，
     */
    @Test
    public void findQuill(){

        for (int i = 0 ; i < 1 ; i++) {
            String loginName = "liuchuanzhi"; //"zhaoliu" + i;
            String pwd = "1";
            String phone = "18812345678";
            String refereePhone = null ;//="19912345603"; //"17812345678";//"18812345677";

            //银行信用卡号
            String cardNumber = "123456789";

            //创建账号
            User user = new User();
            user.setLoginName(loginName);
            user.setPwd(pwd);
            user.setPhone(phone);
            if (refereePhone != null) {
                user.setRefereePhone(refereePhone);
            }
            userController.save(user);

            //认证用户信息
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userService.findUserByLoginName(loginName).getId());
            userInfo.setFullName(loginName);
            userInfo.setIdentityId("303020123456789098");
            userInfoService.save(userInfo);

            //认证储蓄卡
            SavingsCard savingsCard = new SavingsCard();
            savingsCard.setUserId(userService.findUserByLoginName(loginName).getId());
            savingsCard.setCardNumber(cardNumber);
            savingsCard.setCardAddress("上海市");
            savingsCard.setAffiliatedBank("上海浦东发展银行");
            savingsCard.setReservedPhoneNumber("13323332333");
            savingsCardController.saveSavingsCard(savingsCard);

            //认证信用卡
            CreditCard creditCard = new CreditCard();
            creditCard.setUserId(userService.findUserByLoginName(loginName).getId());
            creditCard.setCardNumber(cardNumber + 911);
            creditCard.setAffiliatedBank("上海市");
            creditCard.setValidityDate("20200220");
            creditCard.setCvn("1234567");
            creditCard.setReservedPhoneNumber("13323332333");
            creditCardController.saveCreditCard(creditCard);


        }


    }



    @Test
    public void upGrade(){
        String str = "5faf39c049f911e89f30c85b76076a87";
    }


    @Test
    public void test(){
        /*Map<String,String> map = new HashMap<>();
        map.put("1","123");
        map.put("2","456");
        map.forEach((K,V) -> {
          System.out.println(K+" : "+V);
        });*/

        MedalGrade medalGradeB = medalGradeService.findMedalGradeByGradeAbbreviation("TP");
        MedalGrade medalGradeS = medalGradeService.findMedalGradeByGradeAbbreviation("YP");
        MedalGrade medalGradeG = medalGradeService.findMedalGradeByGradeAbbreviation("JP");
        System.out.println(medalGradeB.getId());
        System.out.println(medalGradeS.getId());
        System.out.println(medalGradeG.getId());
    }

}
