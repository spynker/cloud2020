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

    @RequestMapping("/consul")
    public String paymentConsul(){
        return "spring with consul:" + port + "\t" + UUID.randomUUID().toString();
    }
}
