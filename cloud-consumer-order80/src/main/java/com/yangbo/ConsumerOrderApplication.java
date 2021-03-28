package com.yangbo;

import com.rule.MySelfLoadRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(configuration = MySelfLoadRule.class, name = "CLOUD-PAYMENT-SERVICE")
public class ConsumerOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication.class, args);
    }
}
