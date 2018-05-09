package com.mll.data.testing.quill.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.mll.data.testing.quill.entity.QuillMusic;
import com.mll.data.testing.quill.entity.QuillPlay;
import com.mll.data.testing.quill.service.QuillMusicService;
import com.mll.data.testing.quill.service.QuillPlayService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/quillplay")
public class QuillPlayController {

    @Autowired
    private QuillPlayService quillPlayService;

    @Autowired
    private QuillMusicService quillMusicService;

    @PostMapping("/save")
    public String save(QuillPlay quillPlay){
        quillPlayService.saveQuillPlay(quillPlay);
        return JSONUtil.assemble(Result.SUCCESS,"保存成功");
    }

    @GetMapping("/findQuillPlayByTeleplay")
    public String findQuillPlayByTeleplay(String teleplay){
        QuillPlay quillPlay = quillPlayService.findQuillPlayByTeleplay(teleplay);
        return JSONUtil.assemble(Result.SUCCESS,quillPlay,"查询成功");
    }

    @PostMapping("/saveJson")
    public String saveJson(@RequestParam(name = "json") String json){
        Map<String, Object> map = (Map)JSONObject.parse(json);
        QuillPlay quillPlay = JSON.parseObject(map.get("quillPlay").toString(),new TypeReference<QuillPlay>(){});
        QuillMusic quillMusic = JSON.parseObject(map.get("quillMusic").toString(),new TypeReference<QuillMusic>(){});
        quillMusicService.saveQuillMusic(quillMusic);
        quillPlayService.saveQuillPlay(quillPlay);
        return JSONUtil.assemble(Result.SUCCESS,"Json保存成功");
    }




}
