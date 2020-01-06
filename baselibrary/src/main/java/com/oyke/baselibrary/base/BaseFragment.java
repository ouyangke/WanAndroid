package com.oyke.baselibrary.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * Description:    TODO
 * Author:         oyke
 * CreateDate:     2020/1/1 8:15
 */
public abstract class BaseFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends Fragment implements IView {
    protected final String TAG = getClass().getSimpleName();
    protected V mBinding;
    protected VM mViewModel;
    protected AppCompatActivity mActivity;

    /**
     * 初始化界面传递参数
     */
    protected abstract void initParam();

    /**
     * 初始化layoutId
     *
     * @return 布局layout的id
     */
    protected abstract int initContentView();

    /**
     * 初始化绑定
     */
    protected abstract void initBinding();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化界面观察者的监听
     */
    protected abstract void initViewObservable();


}
