package com.mll.data.testing.spread.service.impl;

import com.mll.data.testing.spread.entity.Graphic;
import com.mll.data.testing.spread.service.GraphicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraphicServiceImplTest {

    @Autowired
    private GraphicService graphicService;

    @Test
    public void saveGraphic() throws Exception {

        Graphic graphicA = new Graphic();
        graphicA.setTitle("陋室铭");
        graphicA.setText("山不在高，有仙则名。水不在深，有龙则灵。斯是陋室，惟吾德馨。苔痕上阶绿，草色入帘青。谈笑有鸿儒，往来无白丁。可以调素琴，阅金经。无丝竹之乱耳，无案牍之劳形。南阳诸葛庐，西蜀子云亭，孔子云：何陋之有？");
        graphicA.setImgOne("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524542909692&di=87edd5171ba1fb4b447a2eb2e4e3874b&imgtype=0&src=http%3A%2F%2Fwww.hnkgs.com%2Fadmin%2Fupfiles%2F20170427171014953015.jpg");
        graphicA.setImgTwo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524543021881&di=361b65ef8214cb6c34e658f9a629b1aa&imgtype=0&src=http%3A%2F%2Fmvimg11.meitudata.com%2F576e6f1e329824815.jpg");
        graphicA.setImgThree("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1524533436&di=115e572853af0766b4e52df6fd9a3214&src=http://www.hgdaily.com.cn/w/3/upfile/4/2018/03/13/20180313171950306008.jpg");
        graphicService.saveGraphic(graphicA);

        Graphic graphicB = new Graphic();
        graphicB.setTitle("传单");
        graphicB.setText("逛街，一个小姐姐在发保险传单，我拿了一份。\n" +
                "走到另一个路口，一个小哥哥过来递我一张传单说：“运动健身了解一下。”\n" +
                "我直接把那张保险传单递过去说：“人寿保险了解一下。”\n" +
                "看着小哥哥扭头就走，我露出了胜利的微笑。");
        graphicB.setImgOne("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2566894598,1890472810&fm=27&gp=0.jpg");
        graphicB.setImgTwo("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2566894598,1890472810&fm=27&gp=0.jpg");
        graphicB.setImgThree("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2566894598,1890472810&fm=27&gp=0.jpg");
        graphicService.saveGraphic(graphicB);

        Graphic graphicC = new Graphic();
        graphicC.setTitle("直播手机碎屏过程");
        graphicC.setText("有个朋友，上厕时把手机放窗台上，一阵风吹过，“啪”一声，手机摔地上，立即拾起来一看，没坏。他寻思了，这风怎么能把手机给吹掉下？于是又把手机放窗台上，然后盯着手机和窗帘看。又一阵风来，窗帘拂动，原来是窗帘下沿带到了手机，“啪”一声，屏碎了。");
        graphicC.setImgOne("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544869832&di=9f3eba67b72d7ebd769239bd36fba070&imgtype=0&src=http%3A%2F%2Fstatic.leiphone.com%2Fuploads%2Fnew%2Farticle%2F740_740%2F201508%2F55dad05b56b04.jpg");
        graphicC.setImgTwo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544869832&di=b0678d88d51411660d53f28434f67008&imgtype=0&src=http%3A%2F%2Fi1.hexun.com%2F2017-06-08%2F189547810.jpg");
        graphicC.setImgThree("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544869832&di=d91b196e390318c8301a58525da2a4eb&imgtype=0&src=http%3A%2F%2Fupload.qing5.com%2F2015%2F1009%2F1444399836449.jpg");
        graphicService.saveGraphic(graphicC);

        Graphic graphicD = new Graphic();
        graphicD.setTitle("爱莲说");
        graphicD.setText("水陆草木之花，可爱者甚蕃。晋陶渊明独爱菊。自李唐来，世人甚爱牡丹。予独爱莲之出淤泥而不染，濯清涟而不妖，中通外直，不蔓不枝，香远益清，亭亭净植，可远观而不可亵玩焉。");
        graphicD.setImgOne("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524543642718&di=15128efff8d8123fa0f5e746fa4ff59b&imgtype=0&src=http%3A%2F%2Fbpic.ooopic.com%2F16%2F04%2F91%2F16049198-f4cc2e79d88aff33530a798620160859-0.jpg");
        graphicD.setImgTwo("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525138374&di=6157044153eef401819a8869114d1ccc&imgtype=jpg&er=1&src=http%3A%2F%2Fpic109.nipic.com%2Ffile%2F20160902%2F23647053_215226248000_2.jpg");
        graphicD.setImgThree("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1524533574&di=ac8f97a409cba52acd9e99eb95b2dfad&src=http://img.zcool.cn/community/01288759b0e737a8012028a970aa32.jpg");
        graphicService.saveGraphic(graphicD);


        Graphic graphicE = new Graphic();
        graphicE.setTitle("银行办业务");
        graphicE.setText("在银行办业务，基友打电话过来，说了两句他就说听不见，叫我把免提开到最大，开了免提之后我就说:好了开好了，你继续说然后我就听见电话里那头嗷唠一嗓子:通通别动，抢银行……");
        graphicE.setImgOne("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524545048878&di=93e0e301c1bacf10527406a21eee21bf&imgtype=0&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2FC%2FC1%2FC11CBF06C99E185B0A96B35FD25A76EC.jpg");
        graphicE.setImgTwo("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=784823576,1339486238&fm=27&gp=0.jpg");
        graphicE.setImgThree("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3001837,3740844985&fm=27&gp=0.jpg");
        graphicService.saveGraphic(graphicE);


       /* Graphic graphic = new Graphic();
        graphic.setTitle("XXXXXXXXXX");
        graphic.setText("xxxxxxxxxxxxx");
        graphic.setImgOne("xxxxxxxxxxxxxx");
        graphic.setImgTwo("xxxxxxxxxxxxxx");
        graphic.setImgThree("xxxxxxxxxxxxxx");
        graphicService.saveGraphic(graphic);*/




    }

}