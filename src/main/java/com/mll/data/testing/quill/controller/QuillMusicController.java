package com.mll.data.testing.quill.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.mll.data.testing.quill.entity.QuillMusic;
import com.mll.data.testing.quill.service.QuillMusicService;
import com.mll.data.testing.util.JSONUtil;
import com.mll.data.testing.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/quillmusic")
public class QuillMusicController {

    @Autowired
    private QuillMusicService quillMusicService;

    @PostMapping("/save")
    public String saveQuillMusic(QuillMusic quillMusic){
        quillMusicService.saveQuillMusic(quillMusic);
        return JSONUtil.assemble(Result.SUCCESS,"保存成功");
    }

    @RequestMapping("/findList")
    public String findPageSong(@RequestParam(value = "songName", required = false)String songName,
                               @RequestParam(value = "singer" ,required = false)String singer,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        Map<String, Object> filters = new HashMap<>();
        filters.put("songName",songName);
        if(singer != null){
            filters.put("singer",singer);
        }
        PageInfo<QuillMusic> page = quillMusicService.findPageSong(filters,pageNum,pageSize);
        return JSONUtil.assemble(Result.SUCCESS,page);
    }

    public String getJson(String json){
        Map<String, Object> jsonMap = (Map) JSONObject.parse(json);
        return "";
    }
}
