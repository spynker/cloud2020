package com.yangbo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/payment")
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/zk")
    public String paymentZk(){
        return "spring with zookeeper:" + port + "\t" + UUID.randomUUID().toString();
    }
}
