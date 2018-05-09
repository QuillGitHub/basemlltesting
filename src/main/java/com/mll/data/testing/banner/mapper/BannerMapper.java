package com.mll.data.testing.banner.mapper;

import com.mll.data.testing.banner.VO.BannerVO;
import com.mll.data.testing.banner.entity.Banner;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-05-08 11:58
 **/

@Repository
public interface BannerMapper extends BaseMapper<Banner> {

    @Select("select * from t_banner where img_type = #{imgType}")
    public List<Banner> findBannerByImgTypeList(Integer imgType);

    @Select("select * from t_banner where img_type = #{imgType}")
    public List<BannerVO> findBannerByImgTypeListVO(Integer imgType);

    @Select("select * from t_banner")
    public List<BannerVO> findAllList();
}
