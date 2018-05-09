package com.mll.data.testing.auditing.mapper;

import com.mll.data.testing.auditing.entity.ExaminePhoto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExaminePhotoMapperTest {

    @Autowired
    private ExaminePhotoMapper examinePhotoMapper;

    @Test
    public void updateExaminePhoto() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("userId","94d384fc411a11e89aa2c85b76076a87");
        map.put("cardFront","身份证正面");//身份证正面
        //map.put("cardBack","身份证反面");//身份证反面
        //map.put("creditCardFront","信用卡正面");//信用卡正面
        //map.put("handheldIdentityCard","手持身份证正面");//手持身份证正面
        //map.put("depositCardFront","银行储蓄卡正面");//银行储蓄卡正面
        //map.put("faceRecognition","人脸识别");//人脸识别
        examinePhotoMapper.updateExaminePhoto(map);
    }

    @Test
    public void findExaminePhotoByUserId(){
        ExaminePhoto examinePhoto = examinePhotoMapper.findExaminePhotoByUserId("94d384fc411a11e89aa2c85b76076a87");
        System.out.println(examinePhoto);
    }

}