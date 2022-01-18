package com.moyu.myadmin.utils;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/12 22:45
 */

public enum ReturnCode {

    /**
     * 操作成功
     **/
    RC200(200, "操作成功"),
    /**
     * 操作失败
     **/
    RC999(999, "操作失败"),

    /**
     * 服务降级
     **/
    RC201(201, "服务开启降级保护,请稍后再试!"),
    /**
     * 热点参数限流
     **/
    RC202(202, "热点参数限流,请稍后再试!"),
    /**
     * 系统规则不满足
     **/
    RC203(203, "系统规则不满足要求,请稍后再试!"),
    /**
     * 授权规则不通过
     **/
    RC204(204, "授权规则不通过,请稍后再试!"),
    /**
     * access_denied
     **/
    RC403(403, "无访问权限,请联系管理员授予权限"),
    /**
     * access_denied
     **/
    RC401(401, "匿名用户访问无权限资源时的异常"),
    /**
     * 服务异常
     **/
    RC500(500, "系统异常，请稍后重试");


    /**
     * 自定义状态码
     **/
    private final int code;
    /**
     * 自定义描述
     **/
    private final String message;

    ReturnCode(int code, String message) {
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
