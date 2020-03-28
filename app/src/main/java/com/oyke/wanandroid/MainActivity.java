package com.oyke.wanandroid;

import com.oyke.baselibrary.base.BaseActivity;
import com.oyke.wanandroid.databinding.ActivityMainBinding;
import com.oyke.wanandroid.viewmodel.state.MainViewModel;

/**
 * Description:    全局application
 * Author:         oyke
 * CreateDate:     2020/1/1 8:15
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected void initParam() {

    }

    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initBinding() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViewObservable() {

    }
}
