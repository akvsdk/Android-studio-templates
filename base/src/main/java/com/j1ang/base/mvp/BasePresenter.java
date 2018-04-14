package com.j1ang.base.mvp;

import android.content.Context;

import com.j1ang.base.rx.RxManager;


/**
 * author  Joy
 * Date:  2017/9/5.
 * version:  V1.0
 * Description:基类Presenter
 */
public abstract class BasePresenter<V extends BaseView>{
    public Context mContext;
    public V mView;
    public RxManager mRxManage = new RxManager();

    public void attachView(V v) {
        this.mView = v;
        if (mView != null) {
            onStart();
        }
    }

    public abstract void onStart();
    public void onDestroy() {
        mRxManage.clear();
        mView = null;
        mContext=null;
    }
}
