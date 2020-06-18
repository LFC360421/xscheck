package com.xscheck.utils;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    private Result(T data){
        this.code= 200;
        this.message="成功";
        this.data=data;
    }
    public Result(){};

    private Result(CodeMsg cm){
        if(cm==null){
            return;
        }
        this.code=cm.getCode();
        this.message=cm.getMessage();
    }

    //成功时调用
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    //成功不需要传入参数
    public static <T> Result<T> success(){
        return (Result<T>) success("");
    }

    //失败时调用
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }

    //失败时调用，拓展消息参数
    public static <T> Result<T> error(CodeMsg cm,String msg) throws CloneNotSupportedException {
        CodeMsg newCodeMsg=null;
        newCodeMsg =(CodeMsg) cm.clone();
        newCodeMsg.setMessage(cm.getMessage()+"--" +msg);
        return new Result<T>(newCodeMsg);
    }
}
