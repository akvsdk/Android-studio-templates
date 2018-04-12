package com.j1ang.base.mvp;

import android.content.Context;

import com.j1ang.base.rx.RxManager;


/**
 * author  Joy
 * Date:  2017/9/5.
 * version:  V1.0
 * Description:基类Presenter
 */
public abstract class BasePresenter<T,E>{
    public Context mContext;
    public E mModel;
    public T mView;
    public RxManager mRxManage = new RxManager();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }
    public void onStart(){
    };
    public void onDestroy() {
        mRxManage.clear();
    }
}
