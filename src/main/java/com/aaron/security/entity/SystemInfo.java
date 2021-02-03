package com.aaron.security.entity;

import org.springframework.beans.factory.annotation.Value;

public class SystemInfo {
    @Value("${version}")
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
