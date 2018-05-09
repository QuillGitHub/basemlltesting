package com.mll.data.testing.testing;

import com.mll.data.testing.medal.controller.MedalGradeController;
import com.mll.data.testing.medal.entity.MedalGrade;
import com.mll.data.testing.medal.service.MedalGradeService;
import com.mll.data.testing.rates.controller.RatesController;
import com.mll.data.testing.rates.entity.Rates;
import com.mll.data.testing.share.StatusSummary;
import com.mll.data.testing.spread.controller.GraphicController;
import com.mll.data.testing.spread.entity.Graphic;
import com.mll.data.testing.upgrade.controller.NeedMoneyController;
import com.mll.data.testing.upgrade.controller.NeedPeopleController;
import com.mll.data.testing.upgrade.entity.NeedMoney;
import com.mll.data.testing.upgrade.entity.NeedPeople;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author Yingjie Qi
 * @create 2018-04-28 10:49
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuillStart {

    @Autowired
    private MedalGradeController medalGradeController;

    @Autowired
    private RatesController ratesController;

    @Autowired
    private NeedMoneyController needMoneyController;

    @Autowired
    private NeedPeopleController needPeopleController;

    @Autowired
    private GraphicController graphicController;

    @Autowired
    private MedalGradeService medalGradeService;

    @Test
    public void QuillButtonStart(){

        // 1 创建牌型（金银铜）
        QuillButtonStartSaveMedalGrade();
        // 2 生成费率，各个等级对应的费率
        QuillButtonStartSaveRates();
        // 3 金额升级牌型所需
        QuillButtonStartSaveNeedMoney();
        // 4 人数升级牌型所需
        QuillButtonStartSaveNeedPeople();
        // 5 推广图文
        QuillButtonStartSaveGraphic();


    }

    /**
     * 1 创建牌型（金银铜）
     */
    public void QuillButtonStartSaveMedalGrade(){
        //创建铜牌
        MedalGrade medalGradeB = new MedalGrade();
        medalGradeB.setGrade("铜牌");
        medalGradeB.setGradeAbbreviation("TP");
        medalGradeController.saveMedalGrade(medalGradeB);

        //创建银牌
        MedalGrade medalGradeS = new MedalGrade();
        medalGradeS.setGrade("银牌");
        medalGradeS.setGradeAbbreviation("YP");
        medalGradeController.saveMedalGrade(medalGradeS);


        //创建金牌
        MedalGrade medalGradeG = new MedalGrade();
        medalGradeG.setGrade("金牌");
        medalGradeG.setGradeAbbreviation("JP");
        medalGradeController.saveMedalGrade(medalGradeG);
    }

    /**
     * 2 生成费率，各个等级对应的费率
     */
    public void QuillButtonStartSaveRates (){
        String[] arrName ={
                "快捷支付",
                "微信支付",
                "支付宝支付"
        } ;

        //获取金银铜id
        MedalGrade medalGradeB = medalGradeService.findMedalGradeByGradeAbbreviation("TP");
        MedalGrade medalGradeS = medalGradeService.findMedalGradeByGradeAbbreviation("YP");
        MedalGrade medalGradeG = medalGradeService.findMedalGradeByGradeAbbreviation("JP");
        System.out.println(medalGradeB.getId());
        System.out.println(medalGradeS.getId());
        System.out.println(medalGradeG.getId());


        for(int i = 0 ; i < arrName.length ; i++){
            //铜牌 有积分
            Rates ratesT = new Rates();
            ratesT.setGradeId(medalGradeB.getId()); // 铜牌
            ratesT.setName(arrName[i]);
            ratesT.setRates(new BigDecimal(0.0045)); // 费率
            ratesT.setSettlement(new BigDecimal(2.00)); // 结算 费用 2元/笔
            ratesT.setQuota(8000); // 额度
            ratesT.setIntegral(1); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(ratesT);

            //铜牌 无积分
            Rates rates1 = new Rates();
            rates1.setGradeId(medalGradeB.getId()); // 铜牌
            rates1.setName(arrName[i]);
            rates1.setRates(new BigDecimal(0.0035)); // 费率
            rates1.setSettlement(new BigDecimal(2)); // 结算 费用 2元/笔
            rates1.setQuota(8000); // 额度
            rates1.setIntegral(2); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(rates1);

            //银牌 有积分
            Rates ratesY = new Rates();
            ratesY.setGradeId(medalGradeS.getId()); // 银牌
            ratesY.setName(arrName[i]);
            ratesY.setRates(new BigDecimal(0.0040)); // 费率
            ratesY.setSettlement(new BigDecimal(2)); // 结算 费用 2元/笔
            ratesY.setQuota(10000); // 额度
            ratesY.setIntegral(1); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(ratesY);

            //银牌 无积分
            Rates rates2 = new Rates();
            rates2.setGradeId(medalGradeS.getId()); // 银牌
            rates2.setName(arrName[i]);
            rates2.setRates(new BigDecimal(0.0030)); // 费率
            rates2.setSettlement(new BigDecimal(2)); // 结算 费用 2元/笔
            rates2.setQuota(10000); // 额度
            rates2.setIntegral(2); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(rates2);

            //金牌 无积分
            Rates ratesJ = new Rates();
            ratesJ.setGradeId(medalGradeG.getId()); // 金牌
            ratesJ.setName(arrName[i]);
            ratesJ.setRates(new BigDecimal(0.0038)); // 费率
            ratesJ.setSettlement(new BigDecimal(2)); // 结算 费用 2元/笔
            ratesJ.setQuota(20000); // 额度
            ratesJ.setIntegral(1); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(ratesJ);

            //金牌 无积分
            Rates rates3 = new Rates();
            rates3.setGradeId(medalGradeG.getId()); // 金牌
            rates3.setName(arrName[i]);
            rates3.setRates(new BigDecimal(0.0028)); // 费率
            rates3.setSettlement(new BigDecimal(2)); // 结算 费用 2元/笔
            rates3.setQuota(20000); // 额度
            rates3.setIntegral(2); // 1有积分 2无积分 （无积分比有积分便宜）
            ratesController.saveRates(rates3);
        }
    }

    /**
     * 3 金额升级牌型所需
     */
    public void QuillButtonStartSaveNeedMoney(){
        //铜牌升银牌
        NeedMoney needMoneyTSY = new NeedMoney();
        needMoneyTSY.setGrade("铜牌升银牌");
        needMoneyTSY.setAbbreviation("BUS");
        needMoneyTSY.setMoney(new BigDecimal(9.9));
        needMoneyTSY.setUpgrade(StatusSummary.UpgradeTo.BRONZEUPGRADESILVER);
        needMoneyController.saveNeedMoney(needMoneyTSY);

        //银牌升金牌
        NeedMoney needMoneyYSJ = new NeedMoney();
        needMoneyYSJ.setGrade("银牌升金牌");
        needMoneyYSJ.setAbbreviation("SUG");
        needMoneyYSJ.setMoney(new BigDecimal(90));
        needMoneyYSJ.setUpgrade(StatusSummary.UpgradeTo.SILVERUPGRADEGOLD);
        needMoneyController.saveNeedMoney(needMoneyYSJ);

        //铜牌升金牌
        NeedMoney needMoneyTSJ = new NeedMoney();
        needMoneyTSJ.setGrade("铜牌升金牌");
        needMoneyTSJ.setAbbreviation("BUG");
        needMoneyTSJ.setMoney(new BigDecimal(99));
        needMoneyTSJ.setUpgrade(StatusSummary.UpgradeTo.BRONZEUPGRADEGOLD);
        needMoneyController.saveNeedMoney(needMoneyTSJ);
    }

    /**
     * 4 人数升级牌型所需
     */
    public void QuillButtonStartSaveNeedPeople(){

        //铜牌升级银牌
        NeedPeople needPeopleTSY = new NeedPeople();
        needPeopleTSY.setGrade("铜牌升银牌");
        needPeopleTSY.setAbbreviation("BUS");
        needPeopleTSY.setPeople(3);
        needPeopleTSY.setUpgrade(StatusSummary.UpgradeTo.BRONZEUPGRADESILVER);
        needPeopleController.saveNeedPeople(needPeopleTSY);

        //银牌升级金牌
        NeedPeople needPeopleYSJ = new NeedPeople();
        needPeopleYSJ.setGrade("银牌升金牌");
        needPeopleYSJ.setAbbreviation("SUG");
        needPeopleYSJ.setPeople(6);
        needPeopleYSJ.setUpgrade(StatusSummary.UpgradeTo.SILVERUPGRADEGOLD);
        needPeopleController.saveNeedPeople(needPeopleYSJ);

        //铜牌升级金牌
        NeedPeople needPeopleTSJ = new NeedPeople();
        needPeopleTSJ.setGrade("铜牌升金牌");
        needPeopleTSJ.setAbbreviation("BUG");
        needPeopleTSJ.setPeople(9);
        needPeopleTSJ.setUpgrade(StatusSummary.UpgradeTo.BRONZEUPGRADEGOLD);
        needPeopleController.saveNeedPeople(needPeopleTSJ);
    }

    /**
     * 5 推广图文
     */
    public void QuillButtonStartSaveGraphic(){
        Graphic graphicA = new Graphic();
        graphicA.setTitle("陋室铭");
        graphicA.setText("山不在高，有仙则名。水不在深，有龙则灵。斯是陋室，惟吾德馨。苔痕上阶绿，草色入帘青。谈笑有鸿儒，往来无白丁。可以调素琴，阅金经。无丝竹之乱耳，无案牍之劳形。南阳诸葛庐，西蜀子云亭，孔子云：何陋之有？");
        graphicA.setImgOne("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524542909692&di=87edd5171ba1fb4b447a2eb2e4e3874b&imgtype=0&src=http%3A%2F%2Fwww.hnkgs.com%2Fadmin%2Fupfiles%2F20170427171014953015.jpg");
        graphicA.setImgTwo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524543021881&di=361b65ef8214cb6c34e658f9a629b1aa&imgtype=0&src=http%3A%2F%2Fmvimg11.meitudata.com%2F576e6f1e329824815.jpg");
        graphicA.setImgThree("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1524533436&di=115e572853af0766b4e52df6fd9a3214&src=http://www.hgdaily.com.cn/w/3/upfile/4/2018/03/13/20180313171950306008.jpg");
        graphicController.saveGraphic(graphicA);

        Graphic graphicB = new Graphic();
        graphicB.setTitle("传单");
        graphicB.setText("逛街，一个小姐姐在发保险传单，我拿了一份。\n" +
                "走到另一个路口，一个小哥哥过来递我一张传单说：“运动健身了解一下。”\n" +
                "我直接把那张保险传单递过去说：“人寿保险了解一下。”\n" +
                "看着小哥哥扭头就走，我露出了胜利的微笑。");
        graphicB.setImgOne("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2566894598,1890472810&fm=27&gp=0.jpg");
        graphicB.setImgTwo("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2566894598,1890472810&fm=27&gp=0.jpg");
        graphicB.setImgThree("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2566894598,1890472810&fm=27&gp=0.jpg");
        graphicController.saveGraphic(graphicB);

        Graphic graphicC = new Graphic();
        graphicC.setTitle("直播手机碎屏过程");
        graphicC.setText("有个朋友，上厕时把手机放窗台上，一阵风吹过，“啪”一声，手机摔地上，立即拾起来一看，没坏。他寻思了，这风怎么能把手机给吹掉下？于是又把手机放窗台上，然后盯着手机和窗帘看。又一阵风来，窗帘拂动，原来是窗帘下沿带到了手机，“啪”一声，屏碎了。");
        graphicC.setImgOne("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544869832&di=9f3eba67b72d7ebd769239bd36fba070&imgtype=0&src=http%3A%2F%2Fstatic.leiphone.com%2Fuploads%2Fnew%2Farticle%2F740_740%2F201508%2F55dad05b56b04.jpg");
        graphicC.setImgTwo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544869832&di=b0678d88d51411660d53f28434f67008&imgtype=0&src=http%3A%2F%2Fi1.hexun.com%2F2017-06-08%2F189547810.jpg");
        graphicC.setImgThree("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544869832&di=d91b196e390318c8301a58525da2a4eb&imgtype=0&src=http%3A%2F%2Fupload.qing5.com%2F2015%2F1009%2F1444399836449.jpg");
        graphicController.saveGraphic(graphicC);

        Graphic graphicD = new Graphic();
        graphicD.setTitle("爱莲说");
        graphicD.setText("水陆草木之花，可爱者甚蕃。晋陶渊明独爱菊。自李唐来，世人甚爱牡丹。予独爱莲之出淤泥而不染，濯清涟而不妖，中通外直，不蔓不枝，香远益清，亭亭净植，可远观而不可亵玩焉。");
        graphicD.setImgOne("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524543642718&di=15128efff8d8123fa0f5e746fa4ff59b&imgtype=0&src=http%3A%2F%2Fbpic.ooopic.com%2F16%2F04%2F91%2F16049198-f4cc2e79d88aff33530a798620160859-0.jpg");
        graphicD.setImgTwo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525138374&di=6157044153eef401819a8869114d1ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fpic109.nipic.com%2Ffile%2F20160902%2F23647053_215226248000_2.jpg");
        graphicD.setImgThree("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1524533574&di=ac8f97a409cba52acd9e99eb95b2dfad&src=http://img.zcool.cn/community/01288759b0e737a8012028a970aa32.jpg");
        graphicController.saveGraphic(graphicD);


        Graphic graphicE = new Graphic();
        graphicE.setTitle("银行办业务");
        graphicE.setText("在银行办业务，基友打电话过来，说了两句他就说听不见，叫我把免提开到最大，开了免提之后我就说:好了开好了，你继续说然后我就听见电话里那头嗷唠一嗓子:通通别动，抢银行……");
        graphicE.setImgOne("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524545048878&di=93e0e301c1bacf10527406a21eee21bf&imgtype=0&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2FC%2FC1%2FC11CBF06C99E185B0A96B35FD25A76EC.jpg");
        graphicE.setImgTwo("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=784823576,1339486238&fm=27&gp=0.jpg");
        graphicE.setImgThree("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3001837,3740844985&fm=27&gp=0.jpg");
        graphicController.saveGraphic(graphicE);


       /* Graphic graphic = new Graphic();
        graphic.setTitle("XXXXXXXXXX");
        graphic.setText("xxxxxxxxxxxxx");
        graphic.setImgOne("xxxxxxxxxxxxxx");
        graphic.setImgTwo("xxxxxxxxxxxxxx");
        graphic.setImgThree("xxxxxxxxxxxxxx");
        graphicService.saveGraphic(graphic);*/

    }

}
