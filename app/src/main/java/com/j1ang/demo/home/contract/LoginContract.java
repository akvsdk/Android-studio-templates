package com.j1ang.demo.home.contract;

import com.j1ang.base.mvp.BaseModel;
import com.j1ang.base.mvp.BasePresenter;
import com.j1ang.base.mvp.BaseView;


/**
 * Date:  2018-4-12 10:13:54
 * version:  V1.0
 * Description:
 *
 * @author Joy
 */

public interface LoginContract {

    interface Model extends BaseModel {
        String setUser();

    }

    interface View extends BaseView {
        void getUser(String s);
    }


    abstract class Presenter extends BasePresenter<View> {
        public abstract void doHttp();

    }


}