package com.mll.data.testing.banner.controller;

import com.mll.data.testing.banner.VO.BannerVO;
import com.mll.data.testing.banner.entity.Banner;
import com.mll.data.testing.banner.service.BannerService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yingjie Qi
 * @create 2018-05-08 12:00
 **/
@RestController
@RequestMapping("/Banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/save")
    public String save(Banner banner){

        bannerService.saveBanner(banner);
        return JSONUtil.assemble(Result.SUCCESS,"保存成功");
    }

    @PostMapping("/findBannerByImgTypeList")
    public String findBannerByImgTypeList(Integer imgType){
        List<Banner> bannerList = bannerService.findBannerByImgTypeList(imgType);
        return JSONUtil.assemble(Result.SUCCESS,bannerList,"查询到符合的轮播图");
    }

    @PostMapping("/findBannerByImgTypeListVO")
    public String findBannerByImgTypeListVO(Integer imgType){
        List<BannerVO> bannerList = bannerService.findBannerByImgTypeListVO(imgType);
        return JSONUtil.assemble(Result.SUCCESS,bannerList,"查询到符合的轮播图VO");
    }

    @GetMapping("/findAllList")
    public String findAllList(){
        List<BannerVO> bannerVOList = bannerService.findAllList();
        return JSONUtil.assemble(Result.SUCCESS,bannerVOList,"查询到轮播图");
    }
}
