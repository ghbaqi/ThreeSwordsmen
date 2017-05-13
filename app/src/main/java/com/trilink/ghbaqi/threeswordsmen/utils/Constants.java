package com.trilink.ghbaqi.threeswordsmen.utils;

/**
 * Created by ghbaqi on 2017/5/12.
 */

public class Constants {
    public static final String COMPAINGAIN_ID = "compaigin_id";
    public static final String WARE           = "ware";

    public static final String USER_JSON = "user_json";
    public static final String TOKEN     = "token";

    public static final String DES_KEY = "Cniao5_123456";

    public static final int REQUEST_CODE         = 0;
    public static final int REQUEST_CODE_PAYMENT = 1;


    public static class API {
        public static final String BASE_URL = "http://112.124.22.238:8081/course_api/";

        public static final String CAMPAIGN_HOME = BASE_URL + "campaign/recommend";  //

        public static final String WARES_HOT          = BASE_URL + "wares/hot";
        // Contants.API.WARES_HOT + "?curPage=" + mCurPage + "&pageSize=" + mPageSize
        // wares/hot?curPage=1&pageSize=5

        public static final String CATEGORY_LIST = BASE_URL + "category/list";    //

        public static final String WARES_LIST         = BASE_URL + "wares/list";
//Contants.API.WARES_CAMPAIN_LIST + "?campaignId=" + mCompaignId + "&orderBy=" + mOrderBy + "&curPage=" + mCurrentPage + "&pageSize=10";
// wares/list?campaignId=1&orderBy=0&curPage=1&pageSize=5&categoryId=5&categoryId=5


        public static final String WARES_DETAIL       = BASE_URL + "wares/detail.html";
        public static final String LOGIN = BASE_URL + "auth/login";


        public static final String WARES_CAMPAIN_LIST = BASE_URL + "wares/campaign/list";


        public static final String REG   = BASE_URL + "auth/reg";

        public static final String USER_DETAIL = BASE_URL + "user/get?id=1";

        public static final String ORDER_CREATE   = BASE_URL + "/order/create";
        public static final String ORDER_COMPLEPE = BASE_URL + "/order/complete";
        public static final String ORDER_LIST     = BASE_URL + "order/list";

        public static final String ADDRESS_LIST   = BASE_URL + "addr/list";
        public static final String ADDRESS_CREATE = BASE_URL + "addr/create";
        public static final String ADDRESS_UPDATE = BASE_URL + "addr/update";

        public static final String FAVORITE_LIST   = BASE_URL + "favorite/list";
        public static final String FAVORITE_CREATE = BASE_URL + "favorite/create";
    }


}
