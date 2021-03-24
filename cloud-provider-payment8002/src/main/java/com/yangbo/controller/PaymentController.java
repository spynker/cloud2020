package com.yangbo.controller;

import cn.hutool.core.util.ObjectUtil;
import com.yangbo.service.PaymentService;
import entities.CommonResult;
import entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/queryById")
    public CommonResult<Payment> queryPaymentById(@RequestParam("id") String id){
        Payment payment = paymentService.queryPaymentById(id);
        if(ObjectUtil.isNotEmpty(payment)){
            return new CommonResult(payment, "查询成功，serverPort为" + serverPort);
        }
        return new CommonResult();
    }

    @PostMapping("/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        paymentService.createPayment(payment);
        return new CommonResult(null);
    }

}
