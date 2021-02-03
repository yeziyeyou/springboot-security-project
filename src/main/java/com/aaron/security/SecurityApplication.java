package com.aaron.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class SecurityApplication {

    private static final Logger logger = LoggerFactory.getLogger(SecurityApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
        logger.info("system init success!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

}
