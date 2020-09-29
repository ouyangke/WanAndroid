package com.oyke.wanandroid;

import android.view.MotionEvent;
import android.view.View;

import com.oyke.baselibrary.base.BaseActivity;
import com.oyke.baselibrary.base.DataBindingConfig;
import com.oyke.wanandroid.util.KeyBoardUtil;
import com.oyke.wanandroid.ui.state.RootViewModel;

/**
 * Description:    根activity
 * Author:         oyke
 * CreateDate:     2020/1/1 8:15
 */
public class RootActivity extends BaseActivity {
    private RootViewModel mRootViewModel;

    @Override
    protected void initViewModel() {
        mRootViewModel = getActivityViewModel(RootViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_root,BR.vm,mRootViewModel);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 如果不是落在EditText区域，则需要关闭输入法
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            View currentFocus = getCurrentFocus();
            if (KeyBoardUtil.isHideKeyboard(currentFocus, ev)) {
                KeyBoardUtil.hideKeyBoard(this, currentFocus);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

}
