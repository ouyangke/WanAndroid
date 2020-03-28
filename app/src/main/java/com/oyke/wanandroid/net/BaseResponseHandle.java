package com.oyke.wanandroid.net;

import com.blankj.utilcode.util.ToastUtils;
import com.orhanobut.logger.Logger;
import com.oyke.wanandroid.data.BaseResponse;

/**
 * 返回预处理
 *
 * @author oyke
 * @date 2019/12/14
 */
public class BaseResponseHandle {

    public static <T> void handleCode(BaseResponse<T> baseResponse) {
        switch (baseResponse.getErrorCode()) {
            case CodeRule.CODE_300:
                //请求失败，不打印Message
                Logger.e("请求失败");
                ToastUtils.showShort("错误代码:", baseResponse.getErrorCode());
                break;
            case CodeRule.CODE_330:
                //请求失败，打印Message
                ToastUtils.showShort(baseResponse.getErrorMsg());
                break;
            case CodeRule.CODE_500:
                //服务器内部异常
                ToastUtils.showShort("错误代码:", baseResponse.getErrorCode());
                break;
            case CodeRule.CODE_503:
                //参数为空
                Logger.e("参数为空");
                break;
            case CodeRule.CODE_502:
                //没有数据
                Logger.e("没有数据");
                break;
            case CodeRule.CODE_510:
                //无效的Token，提示跳入登录页
                ToastUtils.showShort("token已过期，请重新登录");
                //关闭所有页面
                //AppManager.getAppManager().finishAllActivity();
                //跳入登录界面
                //*****该类仅供参考，实际业务Code, 根据需求来定义，******//
                break;
            case CodeRule.CODE_530:
                ToastUtils.showShort("请先登录");
                break;
            case CodeRule.CODE_551:
                ToastUtils.showShort("错误代码:", baseResponse.getErrorCode());
                break;
            default:
                ToastUtils.showShort("错误代码:", baseResponse.getErrorCode());
                break;
        }
    }

    public static final class CodeRule {
        //请求成功, 正确的操作方式
        static final int CODE_200 = 200;
        //请求成功, 消息提示
        static final int CODE_220 = 220;
        //请求失败，不打印Message
        static final int CODE_300 = 300;
        //请求失败，打印Message
        static final int CODE_330 = 330;
        //服务器内部异常
        static final int CODE_500 = 500;
        //参数为空
        static final int CODE_503 = 503;
        //没有数据
        static final int CODE_502 = 502;
        //无效的Token
        static final int CODE_510 = 510;
        //未登录
        static final int CODE_530 = 530;
        //请求的操作异常终止：未知的页面类型
        static final int CODE_551 = 551;
    }
}
