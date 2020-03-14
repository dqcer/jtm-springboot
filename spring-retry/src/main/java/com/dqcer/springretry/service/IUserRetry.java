package com.dqcer.springretry.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import java.rmi.RemoteException;

/**
 * 重试
 * @author dqcer
 * @description
 * @date 8:43 2020/3/14
 */
public interface IUserRetry {

    /**
     * include:定义异常类型，与下面recover方法一一对应，即有几个异常，就应该对应几个recover方法
     * maxAttempts:执行失败后，重试的最多次数
     * 自定义重试的delay延迟时间和multiplier乘数（乘数的作用即：每次延迟时间 = 当前重试次数 * 乘数 , 并且每次延迟时间要 <= maxDelay）
     * maxDelay最大延迟时间默认为30s(30000L)
     *
     * @throws Exception
     */
    @Retryable(include = {RuntimeException.class, RemoteException.class}, maxAttempts = 8, backoff = @Backoff(delay = 2000, maxDelay = 6000, multiplier = 2))
    void server() throws Exception;


    /**
     * 参数和返回值建议与server方法一致
     *
     * @param p
     * @return
     */
    @Recover
    void recover(RuntimeException p);


    /**
     * 参数和返回值建议与server方法一致
     *
     * @param p
     * @return
     */
    @Recover
    void recover(RemoteException p);

}
