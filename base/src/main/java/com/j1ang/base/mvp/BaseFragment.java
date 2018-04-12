package com.j1ang.base.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.j1ang.base.rx.RxManager;
import com.j1ang.base.utils.NullUtil;
import com.j1ang.base.utils.TUtil;
import com.j1ang.base.utils.ToastUitl;


/**
 * 基类fragment
 */

/***************
 * 使用例子
 *********************/
//1.mvp模式
//public class SampleFragment extends BaseFragment<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
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
//public class SampleFragment extends BaseFragment {
//    @Override
//    public int getLayoutResource() {
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
public abstract class BaseFragment<T extends BasePresenter, E> extends Fragment {
    public T mPresenter;
    public E mModel;
    public RxManager mRxManager;
    protected View rootView;
    //控件是否初始化
    private boolean isViewCreated;
    //数据是否加载完成
    private boolean isLoadDataCompleted;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isViewCreated && !isLoadDataCompleted) {
            initData();
            isLoadDataCompleted = true;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            if (setLayoutId() != 0) {
                rootView = inflater.inflate(setLayoutId(), container, false);
            } else {
                throw new IllegalArgumentException("You must return a right contentView layout resource Id");
            }

        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        mRxManager = new RxManager();
        if (NullUtil.isNotNull(mPresenter) || NullUtil.isNotNull(mModel)) {
            mPresenter = TUtil.getT(this, 0);
            mModel = TUtil.getT(this, 1);
        }
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        isViewCreated = true;
        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        if (mPresenter != null) {
            initPresenter();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {
            initData();
            isLoadDataCompleted = true;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != rootView) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        if (mPresenter != null)
            mPresenter.onDestroy();
        mRxManager.clear();
    }

    //初始化view
    public abstract void initView(View view);

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public void initPresenter() {

    }

    //获取布局文件
    public abstract int setLayoutId();

    //初始化数据源
    public abstract void initData();

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     * @param flags
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, int flags, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        intent.addFlags(flags);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 短暂显示Toast提示(来自String)
     **/
    public void showToast(String text) {
        ToastUitl.showShort(text);
    }

    /**
     * 短暂显示Toast提示(id)
     **/
    public void showToast(int resId) {
        ToastUitl.showShort(resId);
    }


}
