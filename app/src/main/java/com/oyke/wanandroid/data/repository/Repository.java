package com.oyke.wanandroid.data.repository;

import com.oyke.baselibrary.base.BaseModel;
import com.oyke.wanandroid.C;
import com.oyke.wanandroid.data.BaseResponse;
import com.oyke.wanandroid.data.api.ApiService;
import com.oyke.wanandroid.data.bean.Banner;
import com.oyke.wanandroid.net.ResponseObserver;
import com.oyke.wanandroid.net.RetrofitClient;
import com.oyke.wanandroid.util.RxUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Description:    数据仓库
 * Author:         oyke
 * CreateDate:     2020/1/5 13:59
 */
public class Repository extends BaseModel implements IRemoteRepository, ILocalRepository {
    private static volatile Repository sRepository;

    private ApiService mApiService;

    private Repository() {
        mApiService = RetrofitClient.getInstance().create(ApiService.class, C.BASE_URL);
    }

    public static Repository getInstance() {
        if (sRepository == null) {
            synchronized (Repository.class) {
                if (sRepository == null) {
                    sRepository = new Repository();
                }
            }
        }
        return sRepository;
    }

    /**
     * 请求数据
     *
     * @param <T>        数据类型
     * @param observable 被观察者
     */
    protected <T> Disposable request(Observable<BaseResponse<T>> observable, ResponseObserver<T> observer) {

        return (DisposableObserver) observable
                //数据预处理
                .compose(RxUtils.preProcessTransformer())
                //异常转换
                .compose(RxUtils.exceptionTransformer())
                //线程调度
                .compose(RxUtils.schedulersTransformer())
                //订阅管理
                .subscribeWith(observer);


    }


    @Override
    public Disposable getBanner(ResponseObserver<List<Banner>> observer) {
        return request(mApiService.getBanner(), observer);
    }
}
