package com.moyu.myadmin.utils;

import lombok.Data;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/12 22:45
 *
 * 公共返回类
 */


@Data
public class ResultData<T> {

    /** 结果状态 ,具体状态码参见ResultData.java*/
    private int code;
    private String message;
    private T data;
    private long timestamp ;


    public ResultData (){
        this.timestamp = System.currentTimeMillis();
    }


    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCode.RC200.getCode());
        resultData.setMessage(ReturnCode.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> error(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }

    public static <T> ResultData<T> error(String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCode.RC999.getCode());
        resultData.setMessage(message);
        return resultData;
    }

}
