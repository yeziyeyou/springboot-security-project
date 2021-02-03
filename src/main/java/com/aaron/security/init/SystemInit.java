package com.aaron.security.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class SystemInit extends ApplicationContextInitializedEvent {

    public SystemInit(SpringApplication application, String[] args, ConfigurableApplicationContext context) {
        super(application, args, context);
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------Application init success!----------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }
}
