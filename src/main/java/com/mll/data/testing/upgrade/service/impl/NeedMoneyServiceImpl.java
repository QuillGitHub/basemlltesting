package com.mll.data.testing.upgrade.service.impl;

import com.mll.data.testing.upgrade.entity.NeedMoney;
import com.mll.data.testing.upgrade.mapper.NeedMoneyMapper;
import com.mll.data.testing.upgrade.service.NeedMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NeedMoneyServiceImpl implements NeedMoneyService{

    @Autowired
    private NeedMoneyMapper needMoneyMapper;

    @Override
    public void saveNeedMoney(NeedMoney needMoney){
        needMoneyMapper.insert(needMoney);
    }

    /**
     * 查询 返回所有升级所需金额
     * @return
     */
    @Override
    public List<NeedMoney> findAll(){
        return needMoneyMapper.findAll();
    }

    /**
     * 查询 根据upgrade 返回对象
     * @param upgrade
     * @return
     */
    @Override
    public NeedMoney findNeedMoneyByUpgrade(Integer upgrade){
        return needMoneyMapper.findNeedMoneyByUpgrade(upgrade);
    }
}
