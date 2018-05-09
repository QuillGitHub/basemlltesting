package com.mll.data.testing.quill.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "s_play")
public class QuillPlay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String teleplay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeleplay() {
        return teleplay;
    }

    public void setTeleplay(String teleplay) {
        this.teleplay = teleplay;
    }

    @Override
    public String toString() {
        return "QuillPlay{" +
                "id='" + id + '\'' +
                ", teleplay='" + teleplay + '\'' +
                '}';
    }
}
