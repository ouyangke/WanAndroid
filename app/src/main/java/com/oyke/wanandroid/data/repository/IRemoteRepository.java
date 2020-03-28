package com.oyke.wanandroid.data.repository;

import com.oyke.wanandroid.data.bean.Banner;
import com.oyke.wanandroid.net.ResponseObserver;

import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Description:    远程数据仓库接口
 * Author:         oyke
 * CreateDate:     2020/1/5 13:55
 */
public interface IRemoteRepository {

    public Disposable getBanner(ResponseObserver<List<Banner>> observer);
}
