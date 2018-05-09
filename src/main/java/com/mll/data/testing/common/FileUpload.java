package com.mll.data.testing.common;

import com.mll.data.testing.banner.entity.Banner;
import com.mll.data.testing.banner.service.BannerService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author Yingjie Qi
 * @create 2018-05-08 15:36
 **/
@RestController
@RequestMapping("/FileUpload")
public class FileUpload {

    @Autowired
    private BannerService bannerService;

    /**
     * 上传 轮播图
     * @param file
     * @param imgName
     * @param jumpPage
     * @return
     */
    @PostMapping("/save")
    public String save(MultipartFile file,String imgName,String jumpPage){
        if(!file.isEmpty()){
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
                        new File("E://Work//IDEA_learn//basemlltesting//src//main//resources//static//img//banner//" +
                                imgName + ".png"))); //保存图片到目录下
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return JSONUtil.assemble(Result.FAILURE,"轮播图上传失败2");//FileNotFoundException 异常
            } catch (IOException e) {
                e.printStackTrace();
                return JSONUtil.assemble(Result.FAILURE,"轮播图上传失败3");//IOException IO异常
            }

        }else{
            return JSONUtil.assemble(Result.FAILURE,"轮播图上传失败1");//"上传失败";//文件为空
        }

        //创建Banner 对象 保存对象
        Banner banner = new Banner();
        banner.setImgName(imgName);
        banner.setJumpPage(jumpPage);
        banner.setImgUrl("/img/banner/"+imgName+".png");
        bannerService.saveBanner(banner);
        return JSONUtil.assemble(Result.SUCCESS,"轮播图上传成功");
    }
}
