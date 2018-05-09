package com.mll.data.testing.medal.controller;

import com.mll.data.testing.medal.entity.MedalGrade;
import com.mll.data.testing.medal.service.MedalGradeService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-04-24 11:27
 **/
@RestController
@RequestMapping("/MedalGrade")
public class MedalGradeController {

    @Autowired
    private MedalGradeService medalGradeService;

    /**
     * 保存 保存等级（金、银、铜。可能有钻石）
     * @param medalGrade
     * @return
     */
    @PostMapping("/save")
    public String saveMedalGrade(MedalGrade medalGrade){
        medalGradeService.saveMedalGrade(medalGrade);
        return JSONUtil.assemble(Result.SUCCESS,"保存等级成功");
    }

    /**
     * 查询 查询所有牌型等级
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(){
        List<MedalGrade> medalGradeList = medalGradeService.findAll();
        return JSONUtil.assemble(Result.SUCCESS,medalGradeList,"查询所有牌型等级");
    }

    /**
     * 查询 根据id 返回对象
     * @param id
     * @return
     */
    @GetMapping("/findMedalGradeById")
    public String findMedalGradeById(String id){
        MedalGrade medalGrade = medalGradeService.findMedalGradeById(id);
        return JSONUtil.assemble(Result.SUCCESS,medalGrade,"查询到这个牌型");
    }

    /**
     * 查询 根据简称 返回对象
     * @param gradeAbbreviation
     * @return
     */
    @GetMapping("/findMedalGradeByGradeAbbreviation")
    public String findMedalGradeByGradeAbbreviation(String gradeAbbreviation){
        MedalGrade medalGrade = medalGradeService.findMedalGradeByGradeAbbreviation(gradeAbbreviation);
        return JSONUtil.assemble(Result.SUCCESS,medalGrade,"查询到这个牌型");
    }

    /**
     * 查询 根据等级牌型 返回对象
     * @param grade
     * @return
     */
    @GetMapping("/findMedalGradeByGrade")
    public String findMedalGradeByGrade(String grade){
        MedalGrade medalGrade = medalGradeService.findMedalGradeByGrade(grade);
        return JSONUtil.assemble(Result.SUCCESS,medalGrade,"查询到这个牌型");
    }
}
