package com.mll.data.testing.user.controller;

import com.mll.data.testing.user.entity.PromotionNumber;
import com.mll.data.testing.user.service.PromotionNumberService;
import com.mll.data.testing.user.vo.PromotionNumberVO;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/PromotionNumber")
public class PromotionNumberController {

    @Autowired
    private PromotionNumberService promotionNumberService;

    @PostMapping("/save")
    public String savePromotionNumber(PromotionNumber promotionNumber){
        promotionNumberService.savePromotionNumber(promotionNumber);
        return JSONUtil.assemble(Result.SUCCESS,"保存推荐人数成功");
    }

    @GetMapping("/findPromotionNumberByUserId")
    public String findPromotionNumberByUserId(String userId){
        PromotionNumber promotionNumber = promotionNumberService.findPromotionNumberByUserId(userId);
        if( promotionNumber == null){
            return JSONUtil.assemble(Result.FAILURE,"没有查到该用户1");
        }
        return  JSONUtil.assemble(Result.SUCCESS,promotionNumber,"查到这个用户推荐的人详细信息");
    }

    @GetMapping("/findPromotionNumberVOByUserId")
    public String findPromotionNumberVOByUserId(String userId){
        PromotionNumber promotionNumber = promotionNumberService.findPromotionNumberByUserId(userId);
        if( promotionNumber == null){
            return JSONUtil.assemble(Result.FAILURE,"没有查到该用户1");
        }
        PromotionNumberVO promotionNumberVO = new PromotionNumberVO();
        BeanUtils.copyProperties(promotionNumber,promotionNumberVO);
        return JSONUtil.assemble(Result.SUCCESS,promotionNumberVO,"查到这个用户推荐的人详细信息");
    }

    @PostMapping("/updatePromotionNumber")
    public String updatePromotionNumber(@RequestParam(value ="userId", required = true) String userId,
                                        @RequestParam(value ="certificationNumber", required = false) String certificationNumber,
                                        @RequestParam(value = "directGoldNumber",required = false) String directGoldNumber,
                                        @RequestParam(value = "directSilverNumber",required = false) String directSilverNumber,
                                        @RequestParam(value = "directBronzeNumber",required = false) String directBronzeNumber,
                                        @RequestParam(value = "indirectGoldNumber",required = false)  String indirectGoldNumber,
                                        @RequestParam(value = "indirectSilverNumber",required = false) String indirectSilverNumber,
                                        @RequestParam(value = "indirectBronzeNumber",required = false) String indirectBronzeNumber){
        PromotionNumber promotionNumber = promotionNumberService.findPromotionNumberByUserId(userId);
        String id = promotionNumber.getId();
        Map<String, Object> filters = new HashMap();
        filters.put("id",id);
        if(certificationNumber != null){
            filters.put("certificationNumber",certificationNumber);
        }
        if(directGoldNumber != null){
            filters.put("directGoldNumber",directGoldNumber);
        }
        if(directSilverNumber != null){
            filters.put("directSilverNumber",directSilverNumber);
        }
        if(directBronzeNumber != null){
            filters.put("directBronzeNumber",directBronzeNumber);
        }
        if(indirectGoldNumber != null){
            filters.put("indirectGoldNumber",indirectGoldNumber);
        }
        if(indirectSilverNumber != null){
            filters.put("indirectSilverNumber",indirectSilverNumber);
        }
        if(indirectBronzeNumber != null){
            filters.put("indirectBronzeNumber",indirectBronzeNumber);
        }
        promotionNumberService.updatePromotionNumber(filters);
        return JSONUtil.assemble(Result.SUCCESS,"更新推荐表成功");
    }
}
