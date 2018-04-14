package com.j1ang.demo.home.presenter;

import com.j1ang.demo.home.contract.LoginContract;
import com.j1ang.demo.home.model.LoginModel;


/**
 * Date:  2018-4-12 10:13:54
 * version:  V1.0
 * Description:
 *
 * @author Joy
 */

public class LoginImpl extends LoginContract.Presenter {

    private LoginModel mModel;

    @Override
    public void onStart() {
        mModel = new LoginModel();
    }

    @Override
    public void doHttp() {

        mView.getUser(mModel.setUser());
        mView.showErrorTip("Error");
    }


}
