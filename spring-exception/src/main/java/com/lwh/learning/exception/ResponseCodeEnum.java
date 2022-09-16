package com.lwh.learning.exception;


public enum ResponseCodeEnum {
    //操作成功
    RSC200(200, "操作成功"),
    //错误请求
    RSC400(400, "错误的请求"),
    //服务异常
    RSC500(500, "系统异常，请稍后重试"),
    ;

    /**
     * 自定义状态码
     **/
    private final int code;
    /**
     * 自定义描述
     **/
    private final String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
