package com.yangbo.service;

import entities.Payment;

public interface PaymentService {
    Payment queryPaymentById(String id);

    void createPayment(Payment payment);
}
