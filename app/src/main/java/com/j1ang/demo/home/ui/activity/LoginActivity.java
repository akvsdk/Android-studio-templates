package com.j1ang.demo.home.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.j1ang.demo.R;
import com.j1ang.demo.base.CommonActivity;
import com.j1ang.demo.home.contract.LoginContract;
import com.j1ang.demo.home.model.LoginModel;
import com.j1ang.demo.home.presenter.LoginImpl;

/**
 * Date:  2018-4-12 10:13:54
 * version:  V1.0
 * Description:
 *
 * @author Joy
 */

public class LoginActivity extends CommonActivity<LoginImpl, LoginModel> implements LoginContract.View {


    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }


    @Override
    public int setLayoutId() {
        return R.layout.activity_home_login;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void showErrorTip(String msg) {
        showErrorToast(msg);
    }

}
