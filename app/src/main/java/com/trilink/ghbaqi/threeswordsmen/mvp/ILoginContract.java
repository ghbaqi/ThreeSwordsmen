package com.trilink.ghbaqi.threeswordsmen.mvp;

import com.trilink.ghbaqi.threeswordsmen.bean.LoginRespMsg;

/**
 * Created by ghbaqi on 2017/5/13.
 *    统一管理登录业务的接口
 */

public interface ILoginContract {

    // 登录的 activity / fragment
    interface LoginView extends IBaseView{
       void  onSuccess(LoginRespMsg loginRespMsg);
        void invalidNameOrPwd(String msg);
    }

    // 进行登录的 请求 和数据处理
    interface LoginPresenter extends IBasePresenter {
        void login(String name, String pwd);
    }
}
