package com.mll.data.testing.quill.controller;

import com.mll.data.testing.quill.entity.QuillPlay;
import com.mll.data.testing.quill.service.QuillPlayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuillPlayControllerTest {

    @Autowired
    private QuillPlayController quillPlayController;

    @Autowired
    private QuillPlayService quillPlayService;

    @Test
    public void save(){
        String[] telePlayArray = {
                "太阳的后裔",
                "仙剑三",
                "古剑奇谭",
                "庆余年"
        };
        int i = 0;
        for(String s : telePlayArray) {
            if(quillPlayService.findQuillPlayByTeleplay(s) != null){//判断teleplay不能存在
                continue;
            }
            QuillPlay qp = new QuillPlay();
            qp.setTeleplay(s);
            quillPlayController.save(qp);
        }
    }


    @Test
    public void testPs(){
        QuillPlay quillPlay = quillPlayService.findQuillPlayByTeleplay("庆余年");
        System.out.println(quillPlay);
    }










}