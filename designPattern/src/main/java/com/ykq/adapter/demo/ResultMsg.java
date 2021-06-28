package com.ykq.adapter.demo;

import lombok.Data;

/**
 * @date 2021/03/25 04:59 PM
 */
@Data
public class ResultMsg {
    private int code;
    private String msg;
    private Object data;

    public ResultMsg(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
