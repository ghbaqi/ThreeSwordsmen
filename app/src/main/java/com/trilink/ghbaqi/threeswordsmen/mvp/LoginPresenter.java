package com.trilink.ghbaqi.threeswordsmen.mvp;

import android.text.TextUtils;

import com.trilink.ghbaqi.threeswordsmen.bean.LoginRespMsg;
import com.trilink.ghbaqi.threeswordsmen.http.RetrofitManager;
import com.trilink.ghbaqi.threeswordsmen.http.RetrofitService;
import com.trilink.ghbaqi.threeswordsmen.utils.Constants;
import com.trilink.ghbaqi.threeswordsmen.utils.DESUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ghbaqi on 2017/5/12.
 */

public class LoginPresenter implements ILoginContract.LoginPresenter {

    private RetrofitService mRetrofitService;
    private ILoginContract.LoginView mLoginView;

    public LoginPresenter(ILoginContract.LoginView loginView) {
        mRetrofitService = RetrofitManager.getInstance().getService(false);
        mLoginView = loginView;
    }

    @Override
    public void login(String phone,String pwd) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(pwd)) {
            mLoginView.invalidNameOrPwd("用户名和密码不能为空！");
            return;
        }
        mRetrofitService.login(phone, DESUtil.encode(Constants.DES_KEY,pwd))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginRespMsg>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull LoginRespMsg loginRespMsg) {
                        mLoginView.onSuccess(loginRespMsg);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mLoginView.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void pause() {

    }

}
