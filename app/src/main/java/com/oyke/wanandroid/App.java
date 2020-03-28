package com.oyke.wanandroid;

import com.oyke.baselibrary.base.BaseApplication;
import com.oyke.wanandroid.viewmodel.callback.AppViewModel;

/**
 * Description:    全局application
 * Author:         oyke
 * CreateDate:     2020/1/5 13:39
 */
public class App extends BaseApplication<AppViewModel> {
    private static App sApp;

    public static App getInstance() {
        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }
}
