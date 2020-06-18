package com.xscheck.utils;

import lombok.Data;

@Data
public class CodeMsg implements Cloneable {
    private int code;
    private String message;

    // 通用异常
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg EMPTY_PARAM_ERROR = new CodeMsg(400, "参数为空");
    public static CodeMsg INTER_ERROR = new CodeMsg(505, "服务端异常");

    private CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (CodeMsg) super.clone();
    }
}
