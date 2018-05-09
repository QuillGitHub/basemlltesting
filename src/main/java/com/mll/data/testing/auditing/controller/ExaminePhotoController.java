package com.mll.data.testing.auditing.controller;

import com.mll.data.testing.auditing.entity.ExaminePhoto;
import com.mll.data.testing.auditing.service.ExaminePhotoService;
import com.mll.data.testing.share.StatusSummary;
import com.mll.data.testing.user.service.UserService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ExaminePhoto")
public class ExaminePhotoController {

    @Autowired
    private ExaminePhotoService examinePhotoService;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveExaminePhoto(ExaminePhoto examinePhoto){
        if(examinePhotoService.findExaminePhotoByUserId(examinePhoto.getUserId()) != null){
            return JSONUtil.assemble(Result.SUCCESS,"保存失败1");// 该用户id 已经存在不能添加
        }
        examinePhotoService.saveExaminePhoto(examinePhoto);
        return JSONUtil.assemble(Result.SUCCESS,"保存成功");
    }

    @GetMapping("/findExaminePhotoByUserId")
    public String findExaminePhotoByUserId(String userId){
        ExaminePhoto examinePhoto =examinePhotoService.findExaminePhotoByUserId(userId);
        return JSONUtil.assemble(Result.SUCCESS,examinePhoto,"查询到该用户");
    }

    @PostMapping("/updateFaceRecognition")
    public String updateFaceRecognition(@RequestParam(value = "userId",required = true)String userId,
                                        @RequestParam(value = "faceRecognition",required = true)String faceRecognition){
        ExaminePhoto examinePhoto = examinePhotoService.findExaminePhotoByUserId(userId);
        String id = examinePhoto.getId();
        Map<String,Object> filters = new HashMap<>();
        filters.put("id",id);
        filters.put("faceRecognition",faceRecognition);
        examinePhotoService.updateExaminePhoto(filters);
        //修改储蓄卡信用卡状态

        //修改用户登录状态
        Map<String,Object> userFilters = new HashMap<>();
        userFilters.put("id",userId);
        userFilters.put("authentication", StatusSummary.Authentication.SUCCESS);
        userService.updateUser(userFilters);

        return JSONUtil.assemble(Result.SUCCESS,"人脸识别认证成功");
    }

    @PostMapping("/updateExaminePhoto")
    public String updateExaminePhoto(@RequestParam(value = "userId",required = true)String userId,
                                     @RequestParam(value = "status",required = false)String status,
                                     @RequestParam(value = "cardFront",required = false)String cardFront,
                                     @RequestParam(value = "cardBack",required = false)String cardBack,
                                     @RequestParam(value = "creditCardFront",required = false)String creditCardFront,
                                     @RequestParam(value = "handheldIdentityCard",required = false)String handheldIdentityCard,
                                     @RequestParam(value = "depositCardFront",required = false)String depositCardFront,
                                     @RequestParam(value = "faceRecognition",required = false)String faceRecognition){
        ExaminePhoto examinePhoto = examinePhotoService.findExaminePhotoByUserId(userId);
        String id = examinePhoto.getId();
        Map<String,Object> filters = new HashMap<>();
        filters.put("id",id);
        if(status != null){
            filters.put("status",status);
        }
        if(cardFront != null){
            filters.put("cardFront",cardFront);
        }
        if(cardBack != null){
            filters.put("cardBack",cardBack);
        }
        if(creditCardFront != null){
            filters.put("creditCardFront",creditCardFront);
        }
        if(handheldIdentityCard != null){
            filters.put("handheldIdentityCard",handheldIdentityCard);
        }
        if(depositCardFront != null){
            filters.put("depositCardFront",depositCardFront);
        }
        if(faceRecognition != null){
            filters.put("faceRecognition",faceRecognition);
        }
        examinePhotoService.updateExaminePhoto(filters);
        return JSONUtil.assemble(Result.SUCCESS,"更新成功");
    }


}
