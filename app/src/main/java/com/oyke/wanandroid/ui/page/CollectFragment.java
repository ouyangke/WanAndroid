package com.oyke.wanandroid.ui.page;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.Toolbar;

import com.oyke.baselibrary.base.BaseFragment;
import com.oyke.wanandroid.R;
import com.oyke.wanandroid.databinding.FragmentCollectBinding;
import com.oyke.wanandroid.viewmodel.state.CollectViewModel;


/**
 * Description:    收藏
 * Author:         oyke
 * CreateDate:     2020/3/29 12:49
 */
public class CollectFragment extends BaseFragment<FragmentCollectBinding, CollectViewModel> {
    private Toolbar mToolbar;

    @Override
    protected void initParam() {

    }

    @Override
    protected int initContentView() {
        return R.layout.fragment_collect;
    }

    @Override
    protected void initBinding() {

    }

    @Override
    protected void initData() {
        mToolbar = mBinding.includeToolbar.toolbar;
        mToolbar.setTitle(R.string.collect);
        mActivity.setSupportActionBar(mToolbar);
        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActivity.getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                nav().popBackStack();
            }
        });
    }

    @Override
    protected void initViewObservable() {

    }
}
