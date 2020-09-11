package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    
    @Resource
    private PaymentService PaymentService;
    
    @PostMapping("payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = PaymentService.create(payment);
        log.info("****插入结果****");
        if(result > 0){
            return new CommonResult(200,"成功");
        }
        return new CommonResult(500,"失败");
    }

    @GetMapping("payment/getById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment result = PaymentService.getPaymentById(id);
        log.info("****查询结果****"+id);
        if(result != null){
            return new CommonResult(200,"成功",result);
        }
        return new CommonResult(500,"失败",null);
    }
}
