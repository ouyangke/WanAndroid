package com.oyke.wanandroid.net;

/**
 * @author oyke
 * @date 2019/12/13
 */
public class ResponseException extends Exception {
    public int code;
    public String message;

    public ResponseException(Throwable t, int code) {
        super(t);
        this.code = code;
    }
}
