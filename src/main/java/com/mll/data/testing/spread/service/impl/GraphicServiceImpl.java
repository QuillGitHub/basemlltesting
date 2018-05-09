package com.mll.data.testing.spread.service.impl;

import com.mll.data.testing.spread.GraphicVO;
import com.mll.data.testing.spread.entity.Graphic;
import com.mll.data.testing.spread.mapper.GraphicMapper;
import com.mll.data.testing.spread.service.GraphicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-04-23 21:27
 **/
@Service
@Transactional
public class GraphicServiceImpl implements GraphicService {

    @Autowired
    private GraphicMapper graphicMapper;

    /**
     * 保存 保存图文推广
     * @param graphic
     */
    @Override
    public void saveGraphic(Graphic graphic){
        //默认当前时间为发布时间
        graphic.setPublishTime(new Date());
        graphicMapper.insert(graphic);
    }

    /**
     * 查询 查看所有图文推广
     * @return
     */
    @Override
    public List<GraphicVO> findAllList(){
        return graphicMapper.findAllList();
    }
}
