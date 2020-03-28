package com.oyke.wanandroid.net;

import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.orhanobut.logger.Logger;

import io.reactivex.observers.DisposableObserver;

/**
 * 响应观察者
 *
 * @author oyke
 * @date 2019/12/14
 */
public abstract class ResponseObserver<T> extends DisposableObserver<T> {

    public abstract void onResult(T t);

    @Override
    public void onNext(T t) {
        onResult(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        //异常处理
        if (e instanceof ResponseException) {
            ResponseException rError = (ResponseException) e;
            ToastUtils.showShort(rError.message);
            return;
        }
        //其他全部甩锅网络异常
        ToastUtils.showShort("网络异常");
    }

    @Override
    public void onComplete() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        //ToastUtils.showShort("http is start");
        // if  NetworkAvailable no !   must to call onCompleted
        if (!NetworkUtils.isConnected()) {
            Logger.d("无网络，读取缓存数据");
            onComplete();
        }
    }
}
