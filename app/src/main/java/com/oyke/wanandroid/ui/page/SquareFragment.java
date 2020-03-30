package com.oyke.wanandroid.ui.page;

import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.NonNull;

import com.oyke.baselibrary.base.BaseFragment;
import com.oyke.wanandroid.R;
import com.oyke.wanandroid.databinding.FragmentSquareBinding;
import com.oyke.wanandroid.viewmodel.state.SquareViewModel;

/**
 * Description:    广场
 * Author:         oyke
 * CreateDate:     2020/3/28 15:27
 */
public class SquareFragment extends BaseFragment<FragmentSquareBinding, SquareViewModel> {
    @Override
    protected void initParam() {

    }

    @Override
    protected int initContentView() {
        return R.layout.fragment_square;
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

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_square,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
