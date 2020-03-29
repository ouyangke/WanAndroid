package com.oyke.wanandroid.ui.page;

import com.blankj.utilcode.util.ToastUtils;
import com.orhanobut.logger.Logger;
import com.oyke.baselibrary.base.BaseFragment;
import com.oyke.wanandroid.R;
import com.oyke.wanandroid.databinding.FragmentHomeBinding;
import com.oyke.wanandroid.viewmodel.state.HomeViewModel;

/**
 * Description:    主页
 * Author:         oyke
 * CreateDate:     2020/1/10 9:47
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> {
    @Override
    protected void initParam() {

    }

    @Override
    protected int initContentView() {
        return R.layout.fragment_home;
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
            ToastUtils.showShort(banners.toString());
        });
    }
}
