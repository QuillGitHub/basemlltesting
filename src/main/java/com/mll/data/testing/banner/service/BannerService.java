package com.mll.data.testing.banner.service;

import com.mll.data.testing.banner.VO.BannerVO;
import com.mll.data.testing.banner.entity.Banner;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-05-08 11:59
 **/

public interface BannerService {
    void saveBanner(Banner banner);

    List<Banner> findBannerByImgTypeList(Integer imgType);

    List<BannerVO> findBannerByImgTypeListVO(Integer imgType);

    List<BannerVO> findAllList();
}
