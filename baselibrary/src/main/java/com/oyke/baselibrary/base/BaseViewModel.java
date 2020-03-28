package com.oyke.baselibrary.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Description:    TODO
 * Author:         oyke
 * CreateDate:     2020/1/1 8:16
 */
public class BaseViewModel extends ViewModel implements IViewModel {

    private CompositeDisposable mCompositeDisposable;

    /**
     * rxjava 添加订阅
     *
     * @param disposable
     */
    protected void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mCompositeDisposable != null) {
            //在viewModel清除的时候解除订阅
            mCompositeDisposable.clear();
        }
    }
}
