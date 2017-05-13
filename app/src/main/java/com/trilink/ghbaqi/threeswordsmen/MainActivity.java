package com.trilink.ghbaqi.threeswordsmen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.trilink.ghbaqi.threeswordsmen.bean.Category;
import com.trilink.ghbaqi.threeswordsmen.bean.HomeCampaign;
import com.trilink.ghbaqi.threeswordsmen.bean.Wares;
import com.trilink.ghbaqi.threeswordsmen.http.RetrofitManager;
import com.trilink.ghbaqi.threeswordsmen.http.RetrofitService;
import com.trilink.ghbaqi.threeswordsmen.utils.Constants;
import com.trilink.ghbaqi.threeswordsmen.utils.DESUtil;
import com.trilink.ghbaqi.threeswordsmen.utils.ToastUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

// 不使用  MVP 模式
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.bt_login)
    Button   mBtLogin;
    @BindView(R.id.bt_home)
    Button   mBtHome;
    @BindView(R.id.bt_cateory)
    Button   mBtCateory;
    @BindView(R.id.bt_wares)
    Button   mBtWares;
    @BindView(R.id.tv_result)
    TextView mTvResult;
    @BindView(R.id.bt_mvp)
    Button   mBtMvp;
    private RetrofitService     mRetrofit;
    private Map<String, Object> params;
    private RetrofitService     mRetrofitServiceString;
    private RetrofitService     mRetrofitServiceJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRetrofit();
        initRetrofitService();
    }

    private void initRetrofitService() {
        mRetrofitServiceString = RetrofitManager.getInstance().getService(true);
        mRetrofitServiceJson = RetrofitManager.getInstance().getService(false);
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //               .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(Constants.API.BASE_URL)
                .build();
        mRetrofit = retrofit.create(RetrofitService.class);
    }


    @OnClick({R.id.bt_login, R.id.bt_home, R.id.bt_cateory, R.id.bt_wares, R.id.bt_mvp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                login();
                break;
            case R.id.bt_home:
                getHomeCompaign();
                break;
            case R.id.bt_cateory:
                getCategoryList();
                break;
            case R.id.bt_wares:
                getWares();
                break;
            case R.id.bt_mvp:
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;
        }
    }

    private void getWares() {
        if (params == null) {
            params = new HashMap<>();
            params.put("campaignId", 3);
            params.put("orderBy", 1);
            params.put("curPage", 1);
            params.put("pageSize", 5);
            params.put("categoryId", 5);
        }
        mRetrofit.getWaresByCategoryId(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Wares>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe:" + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull Wares wares) {
                        mTvResult.setText(wares.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    private void getCategoryList() {
        mRetrofit.getCategoryList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Category>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe:" + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull List<Category> categories) {
                        mTvResult.setText(categories.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    private void login() {
        String name = mEtName.getText().toString().trim();
        String pwd = mEtPwd.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            ToastUtil.showToast(MainActivity.this,"用户吗和密码不能为空");
            return;
        }
        mRetrofitServiceString.loginString(name, DESUtil.encode(Constants.DES_KEY, pwd))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe:" + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        mTvResult.setText(s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    private void getHomeCompaign() {
        mRetrofitServiceJson.getHomeCompaign()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<HomeCampaign>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe:" + d.toString());
                    }

                    @Override
                    public void onNext(@NonNull List<HomeCampaign> homeCampaigns) {
                        mTvResult.setText("onNext:" + homeCampaigns.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }


}
