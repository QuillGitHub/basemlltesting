package com.mll.data.testing.quill.mapper;

import com.mll.data.testing.quill.entity.QuillMusic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuillMusicMapperTest {

    @Autowired
    private QuillMusicMapper quillMusicMapper;

    @Test
    public void updateQuillMusic() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("id","10dfdc0642bd11e8ae03c85b76076a87");
        //map.put("songName","此生不换");
        map.put("singer","青鸟飞鱼");
        quillMusicMapper.updateQuillMusic(map);

    }

    @Test
    public void findList(){
        List<String> ids = new ArrayList<String>();
        ids.add("青鸟飞鱼");
        List<QuillMusic> qm = quillMusicMapper.findSongNameList(ids);
        for(QuillMusic q : qm){
            System.out.println(q);
        }

    }

    @Test
    public void findArray(){
        String[] strings = new String[]{"张芸京"};
        List<QuillMusic> qm = quillMusicMapper.findSongNameArray(strings);
        for(QuillMusic q : qm){
            System.out.println(q);
        }
    }

    @Test
    public  void findMap() {
        List<String> ids = new ArrayList<String>();
        ids.add("李易峰");
        ids.add("张杰");
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        params.put("songName", "剑");
        List<QuillMusic> qm = quillMusicMapper.findMap(params);
        for (QuillMusic q : qm) {
            System.out.println(q);
        }
    }


}