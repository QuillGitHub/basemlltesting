package com.mll.data.testing.quill.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table( name = "s_music")
public class QuillMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String playId;

    private String songName;

    private String singer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "QuillMusic{" +
                "id='" + id + '\'' +
                ", playId='" + playId + '\'' +
                ", songName='" + songName + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}
