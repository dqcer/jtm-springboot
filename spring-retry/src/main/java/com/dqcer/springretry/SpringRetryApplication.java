package com.dqcer.springretry;

import com.dqcer.springretry.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class SpringRetryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringRetryApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        String serverPort = environment.getProperty("server.port");
        serverPort = serverPort == null ? "8080" : serverPort;
        log.info("\n----------------------------------------------------------\n\t" +
                "Application spring-retry running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + serverPort + "/testRetry\n\t" +
                "----------------------------------------------------------");
    }

    UserService userService;

    @Autowired
    void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/testRetry")
    public String testRetry() throws Exception {
        userService.server();
        return "good job";
    }
}