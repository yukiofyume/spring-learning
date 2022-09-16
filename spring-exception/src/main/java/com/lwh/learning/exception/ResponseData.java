package com.lwh.learning.exception;

import lombok.Data;

/**
 * @Author: lwh
 * @Date: 2022年09月16日
 * @Describe: 统一返回格式
 */
@Data
public class ResponseData<T> {
    private int status;
    private String message;
    private T Data;
    private long timestamp;

    public ResponseData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResponseData<T> success(T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setStatus(ResponseCodeEnum.RSC200.getCode());
        responseData.setMessage(ResponseCodeEnum.RSC200.getMessage());
        responseData.setData(data);
        return responseData;
    }

    public static <T> ResponseData<T> fail(int code, String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setStatus(code);
        responseData.setMessage(message);
        return responseData;
    }
}
