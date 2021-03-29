package com.yangbo.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    /**
     * 正常访问
     */
    public String payment_ok(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " payment_info_ok,id:" + id;
    }

    /**
     * 设置超时
     */
    public String payment_timeOut(Integer id){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " payment_info_timeout,id:" + id;
    }
}
