package com.mll.data.testing.upgrade.service.impl;

import com.mll.data.testing.upgrade.entity.NeedPeople;
import com.mll.data.testing.upgrade.mapper.NeedPeopleMapper;
import com.mll.data.testing.upgrade.service.NeedPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NeedPeopleServiceImpl implements NeedPeopleService{

    @Autowired
    private NeedPeopleMapper needPeopleMapper;

    @Override
    public void saveNeedPeople(NeedPeople needPeople){
        needPeopleMapper.insert(needPeople);
    }

    /**
     * 查询 返回所有升级所需人数
     * @return
     */
    @Override
    public List<NeedPeople> findAll(){
        return needPeopleMapper.findAll();
    }

    /**
     * 查询 根据upgrade 返回对象
     * @param upgrade
     * @return
     */
    @Override
    public NeedPeople findNeedPeopleByUpgrade(Integer upgrade){
        return needPeopleMapper.findNeedPeopleByUpgrade(upgrade);
    }
}
