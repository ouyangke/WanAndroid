package com.oyke.wanandroid;

import androidx.navigation.Navigation;

import com.oyke.baselibrary.base.BaseActivity;
import com.oyke.wanandroid.databinding.ActivityRootBinding;
import com.oyke.wanandroid.viewmodel.state.RootViewModel;

/**
 * Description:    根activity
 * Author:         oyke
 * CreateDate:     2020/1/1 8:15
 */
public class RootActivity extends BaseActivity<ActivityRootBinding, RootViewModel> {

    @Override
    protected void initParam() {

    }

    @Override
    protected int initContentView() {
        return R.layout.activity_root;
    }

    @Override
    protected void initBinding() {

    }

    @Override
    protected void initData() {
        Navigation.findNavController(this, R.id.root_fragment_host).navigate(R.id.action_splashFragment_to_homeFragment);
    }

    @Override
    protected void initViewObservable() {

    }
}
