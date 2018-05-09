package com.mll.data.testing.banner.service.impl;

import com.mll.data.testing.banner.VO.BannerVO;
import com.mll.data.testing.banner.entity.Banner;
import com.mll.data.testing.banner.mapper.BannerMapper;
import com.mll.data.testing.banner.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-05-08 11:59
 **/

@Service
@Transactional
public class BannerServiceImpl implements BannerService{

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public void saveBanner(Banner banner){
        bannerMapper.insert(banner);
    }

    @Override
    public List<Banner> findBannerByImgTypeList(Integer imgType){
        List<Banner> bannerList = bannerMapper.findBannerByImgTypeList(imgType);
        return bannerList;
    }

    @Override
    public List<BannerVO> findBannerByImgTypeListVO(Integer imgType){
        List<BannerVO> bannerList = bannerMapper.findBannerByImgTypeListVO(imgType);
        return bannerList;
    }

    @Override
    public List<BannerVO> findAllList(){
         List<BannerVO> bannerVOList = bannerMapper.findAllList();
         return  bannerVOList;
    }
}
