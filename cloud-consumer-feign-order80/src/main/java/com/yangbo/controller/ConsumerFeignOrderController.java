package com.yangbo.controller;

import com.yangbo.entities.CommonResult;
import com.yangbo.entities.Payment;
import com.yangbo.service.ConsumerFeignOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/consumer/feign/")
public class ConsumerFeignOrderController {

    @Autowired
    private ConsumerFeignOrderService consumerFeignOrderService;

    @GetMapping("/queryById")
    public CommonResult<Payment> queryById(String id){
        return consumerFeignOrderService.queryPaymentById(id);
    }
}
