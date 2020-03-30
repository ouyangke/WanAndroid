package com.oyke.wanandroid.util;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Description:    键盘工具类
 * Author:         oyke
 * CreateDate:     2020/3/30 15:50
 */
public class KeyBoardUtil {

    /**
     * 是否落在 EditText 区域
     */
    public static boolean isHideKeyboard(View view, MotionEvent event) {
        if (view instanceof EditText) {
            int[] location = new int[]{0, 0};
            view.getLocationInWindow(location);
            //获取现在拥有焦点的控件view的位置，即EditText
            int left = location[0];
            int top = location[1];
            int bottom = top + view.getHeight();
            int right = left + view.getWidth();
            //判断我们手指点击的区域是否落在EditText上面，如果不是，则返回true，否则返回false
            boolean isInEt = (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom);
            return !isInEt;
        }
        return false;
    }

    /**
     * 关闭软键盘
     */
    public static void hideKeyBoard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 打卡软键盘
     */
    public static void openKeyBoard(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     */
    public static void closeKeyBoard(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
}
