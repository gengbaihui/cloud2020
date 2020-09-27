package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service("PaymentService")
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment Payment) {
        return paymentDao.create(Payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

