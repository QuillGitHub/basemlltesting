package com.mll.data.testing.spread.mapper;

import com.mll.data.testing.spread.GraphicVO;
import com.mll.data.testing.spread.entity.Graphic;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-04-23 21:22
 **/
@Repository
public interface GraphicMapper extends BaseMapper<Graphic> {

    @Select("select * from t_graphic")
    public List<GraphicVO> findAllList();
}
