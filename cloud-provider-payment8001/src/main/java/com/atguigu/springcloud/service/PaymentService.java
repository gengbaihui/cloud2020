package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {
    
    public int create(Payment Payment);
    
    public Payment getPaymentById(Long id);
}
