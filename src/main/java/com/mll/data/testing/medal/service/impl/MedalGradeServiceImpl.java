package com.mll.data.testing.medal.service.impl;

import com.mll.data.testing.medal.entity.MedalGrade;
import com.mll.data.testing.medal.mapper.MedalGradeMapper;
import com.mll.data.testing.medal.service.MedalGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 11:26
 **/
@Service
@Transactional
public class MedalGradeServiceImpl implements MedalGradeService {

    @Autowired
    private MedalGradeMapper medalGradeMapper;

    /**
     * 保存 保存一个等级牌型
     * @param medalGrade
     */
    @Override
    public void saveMedalGrade(MedalGrade medalGrade){
        //判断 这个牌型是否存在
        if(findMedalGradeByGradeAbbreviation(medalGrade.getGradeAbbreviation()) != null){
            return;
        }
        medalGradeMapper.insert(medalGrade);
    }

    /**
     * 查询 查询所有牌型
     * @return
     */
    @Override
    public List<MedalGrade> findAll(){
        return medalGradeMapper.findAll();
    }

    /**
     * 查询 根据id 返回对象
     * @param id
     * @return
     */
    @Override
    public MedalGrade findMedalGradeById(String id){
        return medalGradeMapper.findMedalGradeById(id);
    }

    /**
     * 查询 根据简称 返回对象
     * @param gradeAbbreviation
     * @return
     */
    @Override
    public MedalGrade findMedalGradeByGradeAbbreviation(String gradeAbbreviation){
        return medalGradeMapper.findMedalGradeByGradeAbbreviation(gradeAbbreviation);
    }

    /**
     * 查询 根据等级牌型 返回对象
     * @param grade
     * @return
     */
    @Override
    public MedalGrade findMedalGradeByGrade(String grade){
        return  medalGradeMapper.findMedalGradeByGrade(grade);
    }
}
