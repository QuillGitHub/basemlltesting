package com.mll.data.testing.testing;

import com.alibaba.fastjson.JSONObject;
import com.mll.data.testing.quill.controller.QuillPlayController;
import com.mll.data.testing.quill.entity.QuillMusic;
import com.mll.data.testing.quill.entity.QuillPlay;
import com.mll.data.testing.quill.service.QuillMusicService;
import com.mll.data.testing.quill.service.QuillPlayService;
import com.mll.data.testing.upgrade.entity.UserMoneyUpgrades;
import com.mll.data.testing.upgrade.service.NeedMoneyService;
import com.mll.data.testing.upgrade.service.UserMoneyUpgradesService;
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
public class Liekong {

    @Autowired
    private QuillMusicService quillMusicService;

    @Autowired
    private QuillPlayService quillPlayService;

    @Autowired
    private QuillPlayController quillPlayController;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserMoneyUpgradesService userMoneyUpgradesService;

    @Autowired
    private NeedMoneyService needMoneyService;

    @Test
    public void QuillMusicTest() {
        /*
        QuillPlay quillPlay = new QuillPlay();
        quillPlay.setTeleplay("仙剑奇侠传");
        quillPlayService.saveQuillPlay(quillPlay);
        */

        //包装成JSON
        QuillPlay quillPlay = new QuillPlay();
        quillPlay.setTeleplay("古剑奇谭");

        //包装成JSON
        QuillMusic quillMusic = new QuillMusic();
        quillMusic.setPlayId("14916bfa4ea911e88d2ac85b76076a87");
        quillMusic.setSongName("偏爱");
        quillMusic.setSinger("张芸京");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("quillPlay",quillPlay);
        jsonObject.put("quillMusic",quillMusic);

        System.out.println(jsonObject.toJSONString());
        quillPlayController.saveJson(jsonObject.toJSONString());

    }

    @Test
    public void test1(){
        User user = userService.findUserByid("d007b0734f7911e8929bc85b76076a87");

        UserInfo userInfo = userInfoService.findUserInfoByUserId(user.getId());
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println(userInfo.getDirectSuperior() == null);

        UserMoneyUpgrades userMoneyUpgradesTemp = userMoneyUpgradesService.findUserMoneyUpgradesByUserIdMoney(user.getId(),
                needMoneyService.findNeedMoneyByUpgrade(1).getMoney());

        System.out.println(needMoneyService.findNeedMoneyByUpgrade(1).getMoney());
    }

}