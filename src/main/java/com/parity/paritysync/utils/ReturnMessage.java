package com.parity.paritysync.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回类
 */
public class ReturnMessage implements Serializable {

    public static final int OPERATE_SUCCESS = 0;

    private static final Map<Integer, String> SUCCESS_MESSAGE = new HashMap<Integer, String>() {
        {
            put(OPERATE_SUCCESS, "操作成功!");
        }
    };

    /**
     * 状态码
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 用户返回给浏览器的数据
     */
    private Map<String, Object> extend = new HashMap<>();

    public static ReturnMessage success(int code) {
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode(2000);
        returnMessage.setMsg(SUCCESS_MESSAGE.get(code));
        return returnMessage;
    }

    public static ReturnMessage fail(ErrorMessage errorMessage) {
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode(4000 + errorMessage.getIndex());
        returnMessage.setMsg(errorMessage.getMessage());
        return returnMessage;
    }

    public ReturnMessage add(String key, Object value) {
        this.extend.put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
