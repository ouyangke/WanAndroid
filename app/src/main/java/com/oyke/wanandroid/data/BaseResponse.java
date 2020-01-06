package com.oyke.wanandroid.data;

/**
 * Description:    TODO
 * Author:         oyke
 * CreateDate:     2020/1/1 9:53
 */
public class BaseResponse<T> {
    private T data;
    private int errorCode;
    private String errorMsg;

    public boolean isOk() {
        return 0 == errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
