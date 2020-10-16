package guo.order.controller;

import guo.common.entity.CommonResult;
import guo.common.entity.Payment;
import guo.order.client.PaymentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 17:36
 */
@RestController
public class OrderControllerFeign {
    @Autowired
    private PaymentClient paymentClient;
    @GetMapping("order/feign")
    public CommonResult get(@RequestBody Payment payment){
        return paymentClient.create(payment);
    }
}
