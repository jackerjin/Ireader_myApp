package com.example.tarena.ireader_myapp.entity;

import java.io.Serializable;

/**
 * Created by tarena on 2017/7/8.
 */

public class Comment implements Serializable {
    String avatar;
    String title;
    String count;
    String imgURl;

    public Comment() {
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getImgURl() {
        return imgURl;
    }

    public void setImgURl(String imgURl) {
        this.imgURl = imgURl;
    }
}
