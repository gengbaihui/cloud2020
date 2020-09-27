package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.atguigu.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    
    @Resource
    private PaymentService PaymentService;
    
    @Value("${server.port}")
    private String serverPort;
    
    @PostMapping("payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = PaymentService.create(payment);
        log.info("****插入结果****");
        if(result > 0){
            return new CommonResult(200,"成功 port"+ serverPort);
        }
        return new CommonResult(500,"失败 port"+ serverPort);
    }

    @GetMapping("payment/getById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment result = PaymentService.getPaymentById(id);
        log.info("****查询结果****"+id + "-port" + serverPort);
        if(result != null){
            return new CommonResult(200,"成功 ",result);
        }
        return new CommonResult(500,"失败",null);
    }
}
