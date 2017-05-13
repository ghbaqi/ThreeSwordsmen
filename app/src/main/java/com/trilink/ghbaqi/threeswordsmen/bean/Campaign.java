/*
*Campaign.java
*Created on 2015/10/3 下午10:34 by Ivan
*Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
*http://www.cniao5.com
*/
package com.trilink.ghbaqi.threeswordsmen.bean;

import java.io.Serializable;


public class Campaign implements Serializable {

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    private Long   id;
    private String title;
    private String imgUrl;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
