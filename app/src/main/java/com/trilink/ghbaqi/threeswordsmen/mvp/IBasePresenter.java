package com.trilink.ghbaqi.threeswordsmen.mvp;

/**
 * Created by ghbaqi on 2017/5/12.
 */

public interface IBasePresenter {
    void onCreate();

    void onStart();//暂时没用到

    void onStop();

    void pause();//暂时没用到

//    void attachView(View view);
//
//    void attachIncomingIntent(Intent intent);//暂时没用到
}
