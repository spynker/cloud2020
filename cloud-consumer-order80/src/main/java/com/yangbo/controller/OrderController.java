package com.yangbo.controller;

import com.yangbo.lb.LoadBalancer;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/queryById")
    public CommonResult<Payment> queryById(String id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/queryById?id={id}", CommonResult.class, new HashMap(){{put("id", id);}});
    }

    @GetMapping("/lb/queryById")
    public CommonResult<Payment> queryByLbId(String id){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() == 0){
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "payment/queryById?id={id}", CommonResult.class, new HashMap(){{put("id", id);}});
    }

}
