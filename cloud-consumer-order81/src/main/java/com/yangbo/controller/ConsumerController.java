package com.yangbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/consumer")
@RestController
public class ConsumerController {

    private String restTemplateUrl = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/zk")
    public String getPaymentZk(){
        return restTemplate.getForObject(restTemplateUrl + "/payment/zk", String.class);
    }
}
