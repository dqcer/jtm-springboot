package com.dqcer.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@SpringBootApplication
public class JwtApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JwtApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        String serverPort = environment.getProperty("server.port");
        serverPort = serverPort == null ? "8080" : serverPort;
        log.info("\n----------------------------------------------------------\n\t" +
                "Application jwt running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + serverPort + "/login\n\t" +
                "----------------------------------------------------------");
    }

}
