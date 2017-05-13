package com.trilink.ghbaqi.threeswordsmen.http;

import com.trilink.ghbaqi.threeswordsmen.bean.Category;
import com.trilink.ghbaqi.threeswordsmen.bean.HomeCampaign;
import com.trilink.ghbaqi.threeswordsmen.bean.LoginRespMsg;
import com.trilink.ghbaqi.threeswordsmen.bean.Wares;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by ghbaqi on 2017/5/12.
 */

public interface RetrofitService {

    // 首页列表
    @GET("campaign/recommend")
    Observable<List<HomeCampaign>> getHomeCompaign();

    // 分类一级列表
    @GET("category/list")
    Observable<List<Category>> getCategoryList();

    // 根据 CategoryId 查找某一类 商品
    @GET("wares/list")
    Observable<Wares> getWaresByCategoryId(@QueryMap Map<String, Object> params);

    // 登录
    @FormUrlEncoded
    @POST("auth/login")
    Observable<LoginRespMsg> login(@Field("phone") String phone, @Field("password") String pwd);

    // 登录
    @FormUrlEncoded
    @POST("auth/login")
    Observable<String> loginString(@Field("phone") String phone, @Field("password") String pwd);

}
