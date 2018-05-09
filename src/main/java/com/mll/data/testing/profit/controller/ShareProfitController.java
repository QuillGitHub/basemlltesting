package com.mll.data.testing.profit.controller;

import com.mll.data.testing.profit.entity.ShareProfit;
import com.mll.data.testing.profit.service.ShareProfitService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yingjie Qi
 * @create 2018-05-04 11:50
 **/

@RestController
@RequestMapping("/ShareProfit")
public class ShareProfitController {

    @Autowired
    private ShareProfitService shareProfitService;

    @PostMapping("/save")
    public String saveShareProfit(ShareProfit shareProfit){
        shareProfitService.saveShareProfit(shareProfit);
        return JSONUtil.assemble(Result.SUCCESS,"保存分润信息成功");
    }




}
