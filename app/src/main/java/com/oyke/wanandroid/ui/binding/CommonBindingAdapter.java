package com.oyke.wanandroid.ui.binding;

import androidx.databinding.BindingAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

/**
 * Description:    绑定适配器
 * Author:         oyke
 * CreateDate:     2020/3/29 16:59
 */
public class CommonBindingAdapter {

    @BindingAdapter(value = {"onNavigationItemSelectedListener"}, requireAll = false)
    public static void onNavigationItemSelectedListener(BottomNavigationView view, BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }

    @BindingAdapter(value = {"onNavigationItemSelectedListener"}, requireAll = false)
    public static void onNavigationItemSelectedListener(NavigationView view, NavigationView.OnNavigationItemSelectedListener listener) {
        view.setNavigationItemSelectedListener(listener);
    }

}
