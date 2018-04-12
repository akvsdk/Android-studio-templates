package com.j1ang.demo.base;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.j1ang.base.mvp.BaseFragment;
import com.j1ang.base.mvp.BaseModel;
import com.j1ang.base.mvp.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Date:  2018/4/9.
 * version:  V1.0
 * Description:
 *
 * @author Joy
 */
public abstract class CommonFragment<T extends BasePresenter, E extends BaseModel> extends BaseFragment<T, E> {

    protected Unbinder unbinder;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    protected void showErrorToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}

