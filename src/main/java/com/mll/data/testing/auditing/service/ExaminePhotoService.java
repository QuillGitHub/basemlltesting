package com.mll.data.testing.auditing.service;

import com.mll.data.testing.auditing.entity.ExaminePhoto;

import java.util.Map;

public interface ExaminePhotoService {
    void saveExaminePhoto(ExaminePhoto examinePhoto);

    ExaminePhoto findExaminePhotoByUserId(String userId);

    void updateExaminePhoto(Map<String, Object> filters);

    void updateFaceRecognition(Map<String, Object> filters);
}
