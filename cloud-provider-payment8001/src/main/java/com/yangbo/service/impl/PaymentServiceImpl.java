package com.yangbo.service.impl;

import com.yangbo.dao.PaymentDao;
import com.yangbo.service.PaymentService;
import entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment queryPaymentById(String id) {
        return paymentDao.queryPaymentById(id);
    }

    @Override
    public void createPayment(Payment payment) {
        paymentDao.createPayment(payment);
    }
}
