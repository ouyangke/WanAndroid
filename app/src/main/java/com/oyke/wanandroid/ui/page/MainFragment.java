package com.oyke.wanandroid.ui.page;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.oyke.baselibrary.base.BaseFragment;
import com.oyke.wanandroid.R;
import com.oyke.wanandroid.databinding.FragmentMainBinding;
import com.oyke.wanandroid.viewmodel.state.MainViewModel;


/**
 * Description:    主页
 * Author:         oyke
 * CreateDate:     2020/3/29 12:49
 */
public class MainFragment extends BaseFragment<FragmentMainBinding, MainViewModel> {

    @Override
    protected void initParam() {

    }

    @Override
    protected int initContentView() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initBinding() {

    }

    @Override
    protected void initData() {
        NavController nav = Navigation.findNavController(mActivity, R.id.fh_main);
        NavigationUI.setupWithNavController(mBinding.bnvMain, nav);
        mBinding.bnvMain.setOnNavigationItemSelectedListener(item -> {
            nav.navigate(item.getItemId());
            return false;
        });
    }

    @Override
    protected void initViewObservable() {

    }

}
