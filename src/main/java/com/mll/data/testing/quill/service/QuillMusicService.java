package com.mll.data.testing.quill.service;

import com.github.pagehelper.PageInfo;
import com.mll.data.testing.quill.entity.QuillMusic;

import java.util.Map;

public interface QuillMusicService {
    void saveQuillMusic(QuillMusic quillMusic);

    QuillMusic findQuillMusicBySongName(String songName);

    PageInfo<QuillMusic> findPageSong(Map<String, Object> filters, int pageNum, int pageSize);

    void updateQuillMusic(Map<String, Object> filters);
}
