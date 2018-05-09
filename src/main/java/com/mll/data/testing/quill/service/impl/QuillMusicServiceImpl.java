package com.mll.data.testing.quill.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mll.data.testing.quill.entity.QuillMusic;
import com.mll.data.testing.quill.mapper.QuillMusicMapper;
import com.mll.data.testing.quill.service.QuillMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QuillMusicServiceImpl implements QuillMusicService {

    @Autowired
    private QuillMusicMapper quillMusicMapper;

    @Override
    public void saveQuillMusic(QuillMusic quillMusic){
        quillMusicMapper.insert(quillMusic);
    }

    @Override
    public QuillMusic findQuillMusicBySongName(String songName){
       return quillMusicMapper.findQuillMusicBySongName(songName);
    }

    @Override
    public PageInfo<QuillMusic> findPageSong(Map<String,Object> filters,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<QuillMusic> list = quillMusicMapper.findSong(filters);
        PageInfo<QuillMusic> page = new PageInfo<QuillMusic>(list);
        return page;
    }

    @Override
    public void updateQuillMusic(Map<String,Object> filters){
        quillMusicMapper.updateQuillMusic(filters);
    }
}
