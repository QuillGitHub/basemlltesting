package com.mll.data.testing.quill.service.impl;

import com.mll.data.testing.quill.entity.QuillPlay;
import com.mll.data.testing.quill.mapper.QuillPlayMapper;
import com.mll.data.testing.quill.service.QuillPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuillPlayServiceImpl implements QuillPlayService {

    @Autowired
    private QuillPlayMapper quillPlayMapper;

    @Override
    public void saveQuillPlay(QuillPlay quillPlay){
        quillPlayMapper.insert(quillPlay);
    }

    @Override
    public QuillPlay findQuillPlayByTeleplay(String teleplay){
       return quillPlayMapper.findQuillPlayByTeleplay(teleplay);
    }


}
