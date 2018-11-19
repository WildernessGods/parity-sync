package com.parity.paritysync.utils;

/**
 * @author Administrator on 2018/05/19 0019.
 * @version 1.0
 */
public enum ErrorMessage {

    USER_NAME_PWD_ERROR(1, "用户名或密码错误!"),

    NO_LOGIN(2, "登录信息已过期或身份不合法!"),

    DATA_ERROR(3, "信息格式不正确!"),

    OPERATE_FAILED(4, "操作失败!"),


    Bad_Request(400, "参数解析失败!"),

    NOT_FOUND(404, "接口不存在!"),

    Method_Not_Allowed(405, "不支持当前请求方法!"),

    Unsupported_Media_Type(415, "不支持当前媒体类型!"),

    Internal_Server_Error(500, "服务运行异常!");

    private Integer index;
    private String message;

    ErrorMessage(Integer index, String message) {
        this.index = index;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getIndex() {
        return index;
    }
}
