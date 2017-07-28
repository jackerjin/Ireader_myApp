package com.example.tarena.ireader_myapp.entity;

import java.io.Serializable;

/**
 * Created by tarena on 2017/6/29.
 */

public class BookBrack implements Serializable {
    private String title;
    private String Img_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_url() {
        return Img_url;
    }

    public void setImg_url(String img_url) {
        Img_url = img_url;
    }

}
