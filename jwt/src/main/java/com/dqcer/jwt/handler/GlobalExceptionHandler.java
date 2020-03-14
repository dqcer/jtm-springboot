package com.dqcer.jwt.handler;

import com.dqcer.jwt.vo.ResultCode;
import com.dqcer.jwt.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author dqcer
 * @description
 * @date 10:48 2020/3/14
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ResultVo handleException(RuntimeException e) {
        // 打印异常信息
        log.error("### 异常信息:{} ###", e.getMessage());
        return new ResultVo(e.getMessage());
    }


    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Exception.class)
    public ResultVo handleOtherException(Exception e){
        //打印异常堆栈信息
        e.printStackTrace();
        // 打印异常信息
        log.error("### 不可知的异常:{} ###", e.getMessage());
        return new ResultVo(ResultCode.SYSTEM_INNER_ERROR);
    }

}
