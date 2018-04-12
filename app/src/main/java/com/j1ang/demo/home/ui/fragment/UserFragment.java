package com.j1ang.demo.home.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.j1ang.demo.R;
import com.j1ang.demo.base.CommonFragment;
import com.j1ang.demo.home.contract.UserContract;
import com.j1ang.demo.home.model.UserModel;
import com.j1ang.demo.home.presenter.UserImpl;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Date:  2018-4-12 10:20:01
 * version:  V1.0
 * Description:
 *
 * @author Joy
 */

public class UserFragment extends CommonFragment<UserImpl, UserModel> implements UserContract.View {

    @BindView(R.id.switch1)
    Switch mSwitch1;
    @BindView(R.id.button)
    Button mButton;

    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home_user;
    }

    @Override
    public void initData() {

    }

    @Override
    public void showErrorTip(String msg) {
        showErrorToast(msg);
    }

    @OnClick(R.id.button)
    public void onClick() {
        showToast("hahahaha");
    }
}
