package com.j1ang.demo.base;


import android.widget.Toast;

import com.j1ang.base.mvp.BaseActivity;
import com.j1ang.base.mvp.BasePresenter;
import com.j1ang.base.mvp.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Date:  2018/4/9.
 * version:  V1.0
 * Description:
 *
 * @author Joy
 */
public abstract class CommonActivity<V extends BaseView, P extends BasePresenter> extends BaseActivity<V, P> {

    private Unbinder unbinder;

    @Override
    public void initView() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    protected void showErrorToast(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }


}

