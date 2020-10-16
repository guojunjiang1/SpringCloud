package guo.payment.controller;

import guo.common.entity.CommonResult;
import guo.common.entity.Payment;
import guo.common.entity.ResultCode;
import guo.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/27 19:13
 */
@RestController
@Slf4j
public class PaymentController {
    //注入的第二种方式，直接指定bean的id
    @Resource(name = "paymentServiceImpl")
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        if (i>0){
            return new CommonResult<String>(ResultCode.SUCCESS,port);
        }else {
            return new CommonResult<String>(ResultCode.FAIL,port);
        }
    }

    @GetMapping("payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){
            return new CommonResult<Payment>(ResultCode.SUCCESS,payment);
        }else {
            return new CommonResult(ResultCode.FAIL);
        }
    }
}
