/*
package com.mll.data.testing.medal.controller;

import com.mll.data.testing.medal.entity.MedalGradeRates;
import com.mll.data.testing.medal.service.MedalGradeRatesService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("MedalGradeRates")
public class MedalGradeRatesController {

    @Autowired
    private MedalGradeRatesService medalGradeRatesService;

    @PostMapping("/save")
    public String save(MedalGradeRates medalGradeRates){
        medalGradeRatesService.save(medalGradeRates);
        return "保存成功";
    }

    @GetMapping("/find")
    public MedalGradeRates findMedalGradeRatesByAbbreviation(String gradeAbbreviation){
       return medalGradeRatesService.findMedalGradeRatesByAbbreviation(gradeAbbreviation);
    }

    @GetMapping("/findAll")
    public String findAll(){
        return JSONUtil.assemble(Result.SUCCESS,medalGradeRatesService.findAll());
    }
}
*/
