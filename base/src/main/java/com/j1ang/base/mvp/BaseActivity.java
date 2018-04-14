package com.j1ang.base.mvp;


import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.j1ang.base.app.AppManager;
import com.j1ang.base.rx.RxManager;
import com.j1ang.base.utils.TUtil;
import com.j1ang.base.utils.ToastUitl;


/**
 * 基类
 */

/***************使用例子*********************/
//1.mvp模式
//public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
//    }
//
//    @Override
//    public void initView() {
//    }
//}
//2.普通模式
//public class SampleActivity extends BaseActivity {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//    }
//
//    @Override
//    public void initView() {
//    }
//}
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter> extends AppCompatActivity {
    public P mPresenter;
    public Context mContext;
    public RxManager mRxManager;
    protected V mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetcontentView();
        Bundle extras = getIntent().getExtras();
        setContentView(setLayoutId());
        mContext = this;
        if (null != extras) {
            getBundleExtras(extras);
        }
        mPresenter = TUtil.getT(this, 1);
        mView = this.attachPresenterView();

        if (mPresenter != null) {
            mPresenter.mContext = this;
            if (mView != null) {
                mPresenter.attachView(mView);
            } else {
                throw new NullPointerException("presenter不为空时，view不能为空");
            }
        }

        initView();
        initData();
    }

    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    /*********************子类实现*****************************/
    //获取布局文件
    public abstract int setLayoutId();

    public void getBundleExtras(Bundle extras) {
    }

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract V attachPresenterView();

    //初始化view
    public abstract void initView();

    public abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        if (mRxManager != null)
            mRxManager.clear();
        AppManager.getAppManager().finishActivity(this);
    }

    /**
     * 获取rxmanager
     * 管理单个act rxjava生命周期
     *
     * @return
     */
    public RxManager getRxManager() {
        if (mRxManager == null) {
            synchronized (RxManager.class) {
                if (mRxManager == null) {
                    mRxManager = new RxManager();
                }
            }

        }
        return mRxManager;
    }

    /**
     * 短暂显示Toast提示(来自String)
     **/
    public void showShortToast(String text) {
        ToastUitl.showShort(text);
    }

    /**
     * 短暂显示Toast提示(id)
     **/
    public void showShortToast(int resId) {
        ToastUitl.showShort(resId);
    }

    /**
     * 长时间显示Toast提示(来自res)
     **/
    public void showLongToast(int resId) {
        ToastUitl.showLong(resId);
    }

    /**
     * 长时间显示Toast提示(来自String)
     **/
    public void showLongToast(String text) {
        ToastUitl.showLong(text);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
