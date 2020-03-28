package com.oyke.wanandroid.viewmodel.state;

import androidx.lifecycle.MutableLiveData;

import com.oyke.baselibrary.base.BaseViewModel;
import com.oyke.wanandroid.data.bean.Banner;
import com.oyke.wanandroid.data.repository.Repository;
import com.oyke.wanandroid.net.ResponseObserver;

import java.util.List;

/**
 * Description:    主界面ViewModel
 * Author:         oyke
 * CreateDate:     2020/1/5 14:20
 */
public class MainViewModel extends BaseViewModel {

    private MutableLiveData<List<Banner>> bannersLiveData;

    public MutableLiveData<List<Banner>> getBannersLiveData() {
        if (bannersLiveData == null) {
            bannersLiveData = new MutableLiveData<>();
        }
        return bannersLiveData;
    }


    public void requestBanner() {
        addSubscribe(Repository.getInstance().getBanner(new ResponseObserver<List<Banner>>() {
            @Override
            public void onResult(List<Banner> banners) {
                getBannersLiveData().setValue(banners);
            }
        }));
    }
}
