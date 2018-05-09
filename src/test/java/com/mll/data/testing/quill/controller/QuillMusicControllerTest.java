package com.mll.data.testing.quill.controller;

import com.mll.data.testing.quill.entity.QuillMusic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuillMusicControllerTest {

    @Autowired
    private QuillMusicController quillMusicController;

    @Test
    public void saveQuillMusic() throws Exception {
        for(int k = 0; k < 10 ; k++){
            String[] playName = {
                    "08ee2b4b42ad11e8ae03c85b76076a87",//qingyunian
                    "eec00c4842ac11e8ae03c85b76076a87",//xianjiansan
                    "eec00c4842ac11e8ae03c85b76076a87",//xianjiansan
                    "eec00c4842ac11e8ae03c85b76076a87",//xianjiansan
                    "eec00c4842ac11e8ae03c85b76076a87",//xianjiansan
                    "eec3067142ac11e8ae03c85b76076a87",//gujianqitan
                    "eec3067142ac11e8ae03c85b76076a87",//gujianqitan
                    "eec3067142ac11e8ae03c85b76076a87",//gujianqitan
                    "eec3067142ac11e8ae03c85b76076a87",//gujianqitan
                    "eec3067142ac11e8ae03c85b76076a87",//gujianqitan
                    "eec3067142ac11e8ae03c85b76076a87",//gujianqitan
                    "eead4f2c42ac11e8ae03c85b76076a87",//太阳
                    "eead4f2c42ac11e8ae03c85b76076a87",//太阳
                    "eead4f2c42ac11e8ae03c85b76076a87",//太阳
                    "eead4f2c42ac11e8ae03c85b76076a87",//太阳
                    "eead4f2c42ac11e8ae03c85b76076a87",//太阳

            };

            String[] songName = {
                    "故人叹",
                    "此生不换",
                    "忘记时间",
                    "偏爱",
                    "我做我的王",
                    "剑伤",
                    "剑心",
                    "远方",
                    "ai你没错",
                    "恋人歌",
                    "两人行",
                    "ALWAYS",
                    "Everytime",
                    "This Love",
                    "You Are My Everything",
                    "Once Again",


            };

            String[] singer ={
                    "未知",
                    "青鸟飞鱼",
                    "胡歌",
                    "张芸京",
                    "兄弟联",
                    "李易峰",
                    "张杰",
                    "郁可唯",
                    "张信哲",
                    "胡彦斌",
                    "陈伟霆",
                    "尹美莱",
                    "CHEN、Punch",
                    "DAViCHi",
                    "Gummy",
                    "Mad Clown、金娜英",

            };

            int i = 0;
            for(String s : playName){
                QuillMusic qm = new QuillMusic();
                qm.setPlayId(playName[i]);
                qm.setSongName(songName[i]);
                qm.setSinger(singer[i++]);
                quillMusicController.saveQuillMusic(qm);
            }

        }
    }

    @Test
    public void findPageSong(){

    }

}