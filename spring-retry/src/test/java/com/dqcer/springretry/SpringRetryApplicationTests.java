package com.dqcer.springretry;

import com.dqcer.springretry.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
class SpringRetryApplicationTests {

    @Autowired
    UserService userService;


    @Test
    public void server()  throws Exception{
        userService.server();
    }

}
