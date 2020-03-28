package com.oyke.wanandroid.util;


import com.oyke.wanandroid.data.BaseResponse;
import com.oyke.wanandroid.net.BaseResponseHandle;
import com.oyke.wanandroid.net.ExceptionHandle;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author oyke
 * @date 2019/12/13
 */
public class RxUtils {
    /**
     * 线程调度
     */
    public static ObservableTransformer schedulersTransformer() {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 数据预处理
     * @return
     */
    public static ObservableTransformer preProcessTransformer(){
        return upstream -> upstream
                //数据预处理
                .map(new BaseResponseFunc());
    }

    /**
     * 异常转换
     */
    public static ObservableTransformer exceptionTransformer() {
        return upstream -> upstream
                //异常转换
                .onErrorResumeNext(new HttpResponseFunc<>());
    }

    private static class HttpResponseFunc<T> implements Function<Throwable, Observable<T>> {
        @Override
        public Observable<T> apply(Throwable throwable) {
            return Observable.error(ExceptionHandle.handleException(throwable));
        }
    }

    private static class BaseResponseFunc<T> implements Function<BaseResponse<T>, T> {
        @Override
        public T apply(BaseResponse<T> baseResponse) throws Exception {
            if (!baseResponse.isOk()) {
                BaseResponseHandle.handleCode(baseResponse);
            }
            return baseResponse.getData();
        }
    }


}
