package com.oyke.wanandroid.util;

import android.view.View;
import android.view.animation.AccelerateInterpolator;

import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/**
 * Description:    TODO
 * Author:         oyke
 * CreateDate:     2020/3/30 9:02
 */
public class AnimatorUtil {

    private final static LinearOutSlowInInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
    private final static AccelerateInterpolator LINER_INTERPOLATOR = new AccelerateInterpolator();

    /**
     * 显示View
     *
     * @param view     View
     * @param listener ViewPropertyAnimatorListener
     */
    public static void scaleShow(View view, ViewPropertyAnimatorListener listener) {
        view.setVisibility(View.VISIBLE);
        ViewCompat.animate(view)
                .scaleX(1.0f)
                .scaleY(1.0f)
                .alpha(1.0f)
                .setDuration(800)
                .setListener(listener)
                .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                .start();
    }

    /**
     * 隐藏View
     *
     * @param view     View
     * @param listener ViewPropertyAnimatorListener
     */
    public static void scaleHide(View view, ViewPropertyAnimatorListener listener) {
        ViewCompat.animate(view)
                .scaleX(0.0f)
                .scaleY(0.0f)
                .alpha(0.0f)
                .setDuration(800)
                .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                .setListener(listener)
                .start();
    }

    /**
     * 显示view
     *
     * @param view     View
     * @param listener ViewPropertyAnimatorListener
     */
    public static void translateShow(View view, ViewPropertyAnimatorListener listener) {
        view.setVisibility(View.VISIBLE);
        ViewCompat.animate(view)
                .translationY(0f)
                .setDuration(400)
                .setListener(listener)
                .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                .start();
    }

    /**
     * 隐藏view
     *
     * @param view     View
     * @param listener ViewPropertyAnimatorListener
     */
    public static void translateHide(View view, ViewPropertyAnimatorListener listener) {
        view.setVisibility(View.VISIBLE);
        ViewCompat.animate(view)
                .translationY(350f)
                .setDuration(400)
                .setInterpolator(FAST_OUT_SLOW_IN_INTERPOLATOR)
                .setListener(listener)
                .start();
    }
}
