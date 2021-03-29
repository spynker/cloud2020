package com.yangbo.controller;

import com.yangbo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/payment/hystrix")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment_ok")
    public String paymentOk(@RequestParam("id") Integer id){
       return paymentService.payment_ok(id);
    }

    @GetMapping("/payment_timeout")
    public String paymentTimeout(@RequestParam("id") Integer id){
        return paymentService.payment_timeOut(id);
    }
}
