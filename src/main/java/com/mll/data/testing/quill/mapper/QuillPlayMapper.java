package com.mll.data.testing.quill.mapper;

import com.mll.data.testing.quill.entity.QuillPlay;
import com.mll.data.testing.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface QuillPlayMapper extends BaseMapper<QuillPlay> {

    @Select("select * from s_play where teleplay = #{teleplay}")
    public QuillPlay findQuillPlayByTeleplay(String teleplay);
}
