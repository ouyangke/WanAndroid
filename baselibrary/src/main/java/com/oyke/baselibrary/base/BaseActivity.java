package com.oyke.baselibrary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Description:    基类activity
 * Author:         oyke
 * CreateDate:     2020/1/1 8:15
 */
public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements IView {
    protected final String TAG = getClass().getSimpleName();
    protected V mBinding;
    protected VM mViewModel;


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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam();
        setContentView(initContentView());
        initStateViewModel();
        initBinding();
        initData();
        initViewObservable();
    }

    protected ViewModelProvider getActivityViewModelProvider(AppCompatActivity activity) {
        return new ViewModelProvider(activity, activity.getDefaultViewModelProviderFactory());
    }

    private void initStateViewModel() {
        Class modelClass;
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
            mViewModel = (VM) getActivityViewModelProvider(this).get(modelClass);
        }
    }

}
