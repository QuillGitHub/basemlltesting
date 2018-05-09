package com.mll.data.testing.spread.service;

import com.mll.data.testing.spread.GraphicVO;
import com.mll.data.testing.spread.entity.Graphic;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-04-23 21:26
 **/
public interface GraphicService {
    void saveGraphic(Graphic graphic);

    List<GraphicVO> findAllList();
}
