package com.trilink.ghbaqi.threeswordsmen.http;

import com.trilink.ghbaqi.threeswordsmen.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ghbaqi on 2017/5/13.
 *  创建 RetrofitService 的管理类
 */

public class RetrofitManager {
    private static RetrofitManager mInstance;
    private        RetrofitService mRetrofit01;
    private        RetrofitService mRetrofit02;

    private RetrofitManager() {
    }

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * @param justString true 代表只想返回一个 String 就可以了 ， false 返回 json 对象
     * @return
     */
    public RetrofitService getService(boolean justString) {
        if (justString && mRetrofit01 == null) {
            mRetrofit01 = new Retrofit.Builder()
                    .baseUrl(Constants.API.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(RetrofitService.class);
            return mRetrofit01;

        } else if (mRetrofit02 == null) {
            mRetrofit02 = new Retrofit.Builder()
                    .baseUrl(Constants.API.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(RetrofitService.class);
            return mRetrofit02;
        }

        return (justString ? mRetrofit01 : mRetrofit02);
    }
}
