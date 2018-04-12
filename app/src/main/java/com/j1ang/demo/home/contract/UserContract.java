package com.j1ang.demo.home.contract;

import com.j1ang.base.mvp.BaseModel;
import com.j1ang.base.mvp.BasePresenter;
import com.j1ang.base.mvp.BaseView;

/**
 * Date:  2018-4-12 10:20:01
 * version:  V1.0
 * Description:
 *
 * @author Joy
 */

public interface UserContract {

    interface Model extends BaseModel {

    }

    interface View extends BaseView {

    }


    abstract class Presenter extends BasePresenter<View, Model> {

    }


}