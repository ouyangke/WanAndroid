package com.oyke.wanandroid.ui.binding;

import androidx.databinding.BindingAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Description:    TODO
 * Author:         oyke
 * CreateDate:     2020/3/29 16:59
 */
public class CommonBindingAdapter {

    @BindingAdapter(value = {"onNavigationItemSelectedListener"}, requireAll = false)
    public static void onNavigationItemSelectedListener(BottomNavigationView view, BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }

}
