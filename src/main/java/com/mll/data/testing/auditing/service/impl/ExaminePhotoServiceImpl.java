package com.mll.data.testing.auditing.service.impl;

import com.mll.data.testing.auditing.entity.ExaminePhoto;
import com.mll.data.testing.auditing.mapper.ExaminePhotoMapper;
import com.mll.data.testing.auditing.service.ExaminePhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class ExaminePhotoServiceImpl implements ExaminePhotoService {

    @Autowired
    private ExaminePhotoMapper examinePhotoMapper;

    @Override
    public void saveExaminePhoto(ExaminePhoto examinePhoto){
        if(examinePhotoMapper.findExaminePhotoByUserId(examinePhoto.getUserId()) != null){
            return; // 用户id重复不能添加
        }
        examinePhotoMapper.insert(examinePhoto);
    }

    @Override
    public ExaminePhoto findExaminePhotoByUserId(String userId){
        return examinePhotoMapper.findExaminePhotoByUserId(userId);
    }

    @Override
    public void updateExaminePhoto(Map<String, Object> filters){
        examinePhotoMapper.updateExaminePhoto(filters);
    }

    /**
     * 更新 人脸识别认证
     * @param filters
     */
    @Override
    public void updateFaceRecognition(Map<String, Object> filters){
        examinePhotoMapper.updateFaceRecognition(filters);
    }
}
