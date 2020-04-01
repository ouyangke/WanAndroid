package com.oyke.wanandroid.ui.page;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.Toolbar;

import com.oyke.baselibrary.base.BaseFragment;
import com.oyke.wanandroid.R;
import com.oyke.wanandroid.databinding.FragmentRankBinding;
import com.oyke.wanandroid.viewmodel.state.RankViewModel;


/**
 * Description:    排行榜
 * Author:         oyke
 * CreateDate:     2020/3/29 11:53
 */
public class RankFragment extends BaseFragment<FragmentRankBinding, RankViewModel> {
    private Toolbar mToolbar;

    @Override
    protected void initParam() {

    }

    @Override
    protected int initContentView() {
        return R.layout.fragment_rank;
    }

    @Override
    protected void initBinding() {

    }

    @Override
    protected void initData() {
        mToolbar = mBinding.includeToolbar.toolbar;
        mToolbar.setTitle(R.string.score_list);
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
