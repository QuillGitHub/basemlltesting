package com.mll.data.testing.quill.service;

import com.mll.data.testing.quill.entity.QuillPlay;

public interface QuillPlayService {
    void saveQuillPlay(QuillPlay quillPlay);

    QuillPlay findQuillPlayByTeleplay(String teleplay);
}
