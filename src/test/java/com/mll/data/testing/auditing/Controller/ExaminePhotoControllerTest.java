package com.mll.data.testing.auditing.Controller;

import com.mll.data.testing.auditing.controller.ExaminePhotoController;
import com.mll.data.testing.auditing.entity.ExaminePhoto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExaminePhotoControllerTest {

    @Autowired
    private ExaminePhotoController examinePhotoController;

    @Test
    public void saveExaminePhoto() throws Exception {
        ExaminePhoto examinePhoto = new ExaminePhoto();
        examinePhoto.setUserId("94d384fc411a11e89aa2c85b76076a87");//柳传志

        examinePhotoController.saveExaminePhoto(examinePhoto);
    }

    @Test
    public void findExaminePhotoByUserId(){
        String str = examinePhotoController.findExaminePhotoByUserId("94d384fc411a11e89aa2c85b76076a87");
        System.out.println(str);
    }

    @Test
    public void updateExaminePhoto(){
        //examinePhotoController.updateExaminePhoto("94d384fc411a11e89aa2c85b76076a87","1");

    }

}