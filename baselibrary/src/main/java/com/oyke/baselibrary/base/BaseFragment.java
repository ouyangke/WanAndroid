package com.oyke.baselibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Description:    基类fragment
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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (AppCompatActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initContentView(), container, false);
        mBinding = DataBindingUtil.bind(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initStateViewModel();
        initBinding();
        initData();
        initViewObservable();
    }

    protected NavController nav() {
        return NavHostFragment.findNavController(this);
    }

    protected ViewModelProvider getFragmentViewModelProvider(Fragment fragment) {
        return new ViewModelProvider(fragment, fragment.getDefaultViewModelProviderFactory());
    }

    protected ViewModelProvider getActivityViewModelProvider(AppCompatActivity activity) {
        return new ViewModelProvider(activity, activity.getDefaultViewModelProviderFactory());
    }

    private void initStateViewModel() {
        Class modelClass;
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
            mViewModel = (VM) getFragmentViewModelProvider(this).get(modelClass);
        }
    }

}
