package com.yangbo.service;

import com.yangbo.entities.CommonResult;
import com.yangbo.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface ConsumerFeignOrderService {

    @GetMapping("/payment/queryById")
    CommonResult<Payment> queryPaymentById(@RequestParam("id") String id);

    @GetMapping("/payment/hystrix/payment_ok")
    String paymentOk(@RequestParam("id") Integer id);

    @GetMapping("/payment/hystrix/payment_timeout")
    String paymentTimeout(@RequestParam("id") Integer id);
}
