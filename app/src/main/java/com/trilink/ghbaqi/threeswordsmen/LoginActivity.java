package com.trilink.ghbaqi.threeswordsmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.trilink.ghbaqi.threeswordsmen.bean.LoginRespMsg;
import com.trilink.ghbaqi.threeswordsmen.mvp.ILoginContract;
import com.trilink.ghbaqi.threeswordsmen.mvp.LoginPresenter;
import com.trilink.ghbaqi.threeswordsmen.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ghbaqi on 2017/5/13.
 *  使用 MVP 模式的登录
 */


public class LoginActivity extends AppCompatActivity implements ILoginContract.LoginView {
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.bt_login)
    Button   mBtLogin;
    @BindView(R.id.tv_result)
    TextView mTvResult;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.bt_login)
    public void onClick() {
        mPresenter.login(mEtName.getText().toString().trim(),mEtPwd.getText().toString().trim());
    }

    @Override
    public void onError(String error) {
        ToastUtil.showToast(LoginActivity.this,error);
    }

    @Override
    public void onSuccess(LoginRespMsg loginRespMsg) {
        mTvResult.setText(loginRespMsg.toString());
    }

    @Override
    public void invalidNameOrPwd(String msg) {
       ToastUtil.showToast(LoginActivity.this,msg);
    }
}
