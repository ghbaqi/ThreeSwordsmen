/*
*CampaignRecommendEx.java
*Created on 2015/10/4 上午12:12 by Ivan
*Copyright(c)2014 Guangzhou Onion Information Technology Co., Ltd.
*http://www.cniao5.com
*/
package com.trilink.ghbaqi.threeswordsmen.bean;

import java.io.Serializable;

/**
 *   首页列表数据
 */
public class HomeCampaign implements Serializable {

    @Override
    public String toString() {
        return "HomeCampaign{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cpOne=" + cpOne +
                ", cpTwo=" + cpTwo +
                ", cpThree=" + cpThree +
                '}';
    }

    private Long     id;
    private String   title;
    private Campaign cpOne;
    private Campaign cpTwo;
    private Campaign cpThree;


    public Campaign getCpOne() {
        return cpOne;
    }

    public void setCpOne(Campaign cpOne) {
        this.cpOne = cpOne;
    }

    public Campaign getCpTwo() {
        return cpTwo;
    }

    public void setCpTwo(Campaign cpTwo) {
        this.cpTwo = cpTwo;
    }

    public Campaign getCpThree() {
        return cpThree;
    }

    public void setCpThree(Campaign cpThree) {
        this.cpThree = cpThree;
    }


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
}
