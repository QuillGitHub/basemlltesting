package com.mll.data.testing.profit.service.impl;

import com.mll.data.testing.profit.entity.ShareProfit;
import com.mll.data.testing.profit.mapper.ShareProfitMapper;
import com.mll.data.testing.profit.service.ShareProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Yingjie Qi
 * @create 2018-05-04 11:49
 **/

@Service
@Transactional
public class ShareProfitServiceImpl implements ShareProfitService {

    @Autowired
    private ShareProfitMapper shareProfitMapper;

    @Override
    public void saveShareProfit(ShareProfit shareProfit){
        shareProfit.setShareProfitTime(new Date());//保存当前的时间
        shareProfitMapper.insert(shareProfit);
    }

}
