package com.lh.utils;

import lombok.Data;


@Data
public class ResultResponse {
    /**
     * 状态码:默认为0,
     */
    private int code;
    /**
     * 状态
     */
    private boolean status=false;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object obje;

    public void setCode(int code) {
        if (code == 0) {
            this.status = true;
        }
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObje() {
        return obje;
    }

    public void setObje(Object obje) {
        this.obje = obje;
    }
}