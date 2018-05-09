package com.mll.data.testing.spread.controller;

import com.mll.data.testing.spread.GraphicVO;
import com.mll.data.testing.spread.entity.Graphic;
import com.mll.data.testing.spread.service.GraphicService;
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
 * @create 2018-04-23 21:27
 **/
@RestController
@RequestMapping("/Graphic")
public class GraphicController {

    @Autowired
    private GraphicService graphicService;

    @PostMapping("/save")
    public String saveGraphic(Graphic graphic){
        graphicService.saveGraphic(graphic);
        return JSONUtil.assemble(Result.SUCCESS,"新增一个图文推广");
    }

    @GetMapping("/findAllList")
    public String findAllList(){
        List<GraphicVO> graphicVO = graphicService.findAllList();
        //作者可添加
        return JSONUtil.assemble(Result.SUCCESS,graphicVO,"返回所有图文推广");
    }
}
