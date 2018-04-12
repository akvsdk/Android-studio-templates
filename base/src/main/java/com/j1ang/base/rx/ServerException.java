package com.j1ang.base.rx;

/**
 * author  Joy
 * Date:  2017/9/5.
 * version:  V1.0
 * Description:
 */
public class ServerException extends Exception {
    private Integer code;

    public ServerException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
