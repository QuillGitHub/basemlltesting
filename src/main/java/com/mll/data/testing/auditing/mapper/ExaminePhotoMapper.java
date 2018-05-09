package com.mll.data.testing.auditing.mapper;

import com.mll.data.testing.auditing.entity.ExaminePhoto;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ExaminePhotoMapper extends BaseMapper<ExaminePhoto>{

    @Select("select * from t_examine_photo where user_id = #{userId}")
    public ExaminePhoto findExaminePhotoByUserId(String userId);

    public void updateExaminePhoto(Map<String,Object> filters);

    public void updateFaceRecognition(Map<String, Object> filters);
}
