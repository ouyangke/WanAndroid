package com.oyke.wanandroid;

import com.orhanobut.logger.Logger;
import com.oyke.baselibrary.base.BaseActivity;
import com.oyke.wanandroid.databinding.ActivityMainBinding;
import com.oyke.wanandroid.viewmodel.state.MainViewModel;

/**
 * Description:    主activity
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
        mViewModel.requestBanner();
    }

    @Override
    protected void initViewObservable() {
        mViewModel.getBannersLiveData().observe(this, banners -> {
            Logger.d("获取到banner数据:" + banners);
        });
    }
}
