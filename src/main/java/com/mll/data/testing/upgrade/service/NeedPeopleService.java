package com.mll.data.testing.upgrade.service;

import com.mll.data.testing.upgrade.entity.NeedPeople;

import java.util.List;

public interface NeedPeopleService {
    void saveNeedPeople(NeedPeople needPeople);

    List<NeedPeople> findAll();

    NeedPeople findNeedPeopleByUpgrade(Integer upgrade);
}
