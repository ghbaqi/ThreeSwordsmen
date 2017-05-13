package com.trilink.ghbaqi.threeswordsmen.bean;

import java.util.List;

/**
 * Created by ghbaqi on 2017/5/12.
 */

public class Wares {
    @Override
    public String toString() {
        return "Wares{" +
                "copyright='" + copyright + '\'' +
                ", totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", orders=" + orders +
                ", list=" + list +
                '}';
    }

    /**
     * copyright : 本API接口只允许菜鸟窝(http://www.cniao5.com)用户使用,其他机构或者个人使用均为侵权行为
     * totalCount : 23
     * currentPage : 1
     * totalPage : 0
     * pageSize : 5
     * orders : []
     * list : [{"id":1,"categoryId":5,"campaignId":1,"name":"联想（Lenovo）拯救者14.0英寸游戏本（i7-4720HQ 4G 1T硬盘 GTX960M 2G独显 FHD IPS屏 背光键盘）黑","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_55c1e8f7N4b99de71.jpg","price":5979,"sale":8654},{"id":6,"categoryId":5,"campaignId":7,"name":"未来人类（Terrans Force）X599 15.6英寸游戏本（E3-1231V3 8G 1TB GTX970M 6G独显 3K高清屏）黑","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_55ec08c8Nd34f91bc.jpg","price":9999,"sale":8814},{"id":7,"categoryId":5,"campaignId":18,"name":"华硕（ASUS）飞行堡垒FX50JX 15.6英寸游戏笔记本电脑（i5-4200H 4G 7200转500G GTX950M 2G独显 全高清）","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_5604b257Ne3fd1a5e.jpg","price":4799,"sale":6844},{"id":8,"categoryId":5,"campaignId":9,"name":"得力（deli）33123 至尊金贵系列大型办公家用保管箱 全钢防盗 震动报警 高65CM","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_5456e410N65ff4160.jpg","price":698,"sale":7777},{"id":9,"categoryId":5,"campaignId":4,"name":"AMD Athlon X4（速龙四核）860K盒装CPU （Socket FM2+/3.7GHz/4M/95W）","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_5411486aN1d4ddc5d.jpg","price":29,"sale":8355}]
     */

    private String copyright;
    private int            totalCount;
    private int            currentPage;
    private int            totalPage;
    private int            pageSize;
    private List<?>        orders;
    private List<ListBean> list;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getOrders() {
        return orders;
    }

    public void setOrders(List<?> orders) {
        this.orders = orders;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 1
         * categoryId : 5
         * campaignId : 1
         * name : 联想（Lenovo）拯救者14.0英寸游戏本（i7-4720HQ 4G 1T硬盘 GTX960M 2G独显 FHD IPS屏 背光键盘）黑
         * imgUrl : http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_55c1e8f7N4b99de71.jpg
         * price : 5979.0
         * sale : 8654
         */

        private int id;
        private int    categoryId;
        private int    campaignId;
        private String name;
        private String imgUrl;
        private double price;
        private int    sale;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(int campaignId) {
            this.campaignId = campaignId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getSale() {
            return sale;
        }

        public void setSale(int sale) {
            this.sale = sale;
        }
    }
}
