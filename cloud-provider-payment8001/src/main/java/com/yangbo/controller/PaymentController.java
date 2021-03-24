package com.yangbo.controller;

import cn.hutool.core.util.ObjectUtil;
import com.yangbo.service.PaymentService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/queryById")
    public CommonResult<Payment> queryPaymentById(@RequestParam("id") String id){
        Payment payment = paymentService.queryPaymentById(id);
        if(ObjectUtil.isNotEmpty(payment)){
            return new CommonResult(payment,"查询成功,端口号为" + serverPort);
        }
        return new CommonResult();
    }

    @PostMapping("/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        paymentService.createPayment(payment);
        return new CommonResult(null);
    }


    @GetMapping("/discovery")
    public String discovery(){
        List<String> services = discoveryClient.getServices();
        log.info(services.toString());

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instances){
            log.info("------------------------------------------------------------------");
            log.info(instance.getInstanceId());
            log.info(instance.getServiceId());
            log.info("------------------------------------------------------------------");
        }
        return null;
    }
}
