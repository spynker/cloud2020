package com.yangbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Consumer81Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer81Application.class, args);
    }
}
