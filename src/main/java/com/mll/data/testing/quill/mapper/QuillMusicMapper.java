package com.mll.data.testing.quill.mapper;

import com.mll.data.testing.quill.entity.QuillMusic;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface QuillMusicMapper extends BaseMapper<QuillMusic> {

    @Select("select * from s_music where songName = #{songName}")
    public QuillMusic findQuillMusicBySongName(String songName);

    //查找返回数值
    public List<QuillMusic> findSongNameByStatus(Map<String, Object> filters);

    //动态sql 查找
    public List<QuillMusic> findSong(Map<String,Object> filters);

    //动态sql 更新
    public void updateQuillMusic(Map<String,Object> filters);

    //根据字段 List 查
    public List<QuillMusic> findSongNameList(List<String> ids);

    //根据字段 Array
    public List<QuillMusic> findSongNameArray(String[] strings);

    //多字段 Map
    public List<QuillMusic> findMap(Map<String,Object> map);
}
