package com.yangbo.dao;

import entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao {
    Payment queryPaymentById(@Param("id") String id);

    void createPayment(Payment payment);
}
