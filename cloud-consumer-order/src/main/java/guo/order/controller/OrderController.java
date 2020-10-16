package guo.order.controller;

import guo.common.entity.CommonResult;
import guo.common.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/28 9:43
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return  restTemplate.postForObject("http://CLOUD-PAYMENT-PROVIDER/payment/create",payment,CommonResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult payment(@PathVariable("id") Long id){
       return restTemplate.getForObject("http://CLOUD-PAYMENT-PROVIDER/payment/get/"+id,CommonResult.class);
    }
}
