package com.dqcer.springretry.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

@Slf4j
@Service
public class UserService implements IUserRetry {


    private int index;


    @Override
    public void server() throws Exception {
        log.info(System.currentTimeMillis() + "");
        log.info("执行次数" + (++ index));
        if (index < 2) {
            throw new RuntimeException();
        } else if (index >= 2 && index < 5 ) {
            throw new RemoteException();
        }
    }

    @Override
    public void recover(RuntimeException e) {
        log.info("如果最后一次执行还是失败，并且是RuntimeException异常的", e);
    }

    @Override
    public void recover(RemoteException e) {
        log.info("如果最后一次执行还是失败，并且是RemoteException异常的", e);
    }


}
