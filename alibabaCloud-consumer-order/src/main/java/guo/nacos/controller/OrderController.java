package guo.nacos.controller;

import guo.nacos.client.PaymentClient;
import guo.nacos.client.PaymentClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/1 20:04
 */
@RestController
public class OrderController {
    @Autowired
    private PaymentClients paymentClients;
    @GetMapping("nacos/consumer/{id}")
    public String get(@PathVariable("id") Integer id){
        return paymentClients.getPayment(id);
    }
}
