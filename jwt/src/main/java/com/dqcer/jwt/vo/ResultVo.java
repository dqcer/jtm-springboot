package com.dqcer.jwt.vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    //操作代码
    int code;

    //提示信息
    String message;

    //结果数据
    T data;

    public ResultVo(ResultCode resultCode){
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public ResultVo(ResultCode resultCode, T data){
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public ResultVo(String message){
        this.message = message;
    }

    public static ResultVo SUCCESS(){
        return new ResultVo(ResultCode.SUCCESS);
    }

    public static <T> ResultVo SUCCESS(T data){
        return new ResultVo(ResultCode.SUCCESS, data);
    }

    public static ResultVo FAIL(){
        return new ResultVo(ResultCode.FAIL);
    }

    public static ResultVo FAIL(String message){
        return new ResultVo(message);
    }
}
