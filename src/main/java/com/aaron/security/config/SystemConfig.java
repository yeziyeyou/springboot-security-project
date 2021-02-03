package com.aaron.security.config;

import com.aaron.security.entity.SystemInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {

    @Bean
    public SystemInfo systemInfo(){
        SystemInfo systemInfo = new SystemInfo();
        return systemInfo;
    }
}
