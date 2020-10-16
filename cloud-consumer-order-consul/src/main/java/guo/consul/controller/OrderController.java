package guo.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 9:19
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/consul")
    public String get(){
        return restTemplate.getForObject("http://provider-payment-consul/payment/find",String.class);
    }
}
