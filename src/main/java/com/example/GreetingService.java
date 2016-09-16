package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("greeting")
@RefreshScope
public class GreetingService {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String greet() {
        return this.message;
    }

    public String greet(String name) {
        return this.message + " " + name;
    }

}
