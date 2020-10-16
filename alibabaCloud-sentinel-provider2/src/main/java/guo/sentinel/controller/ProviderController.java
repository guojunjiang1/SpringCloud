package guo.sentinel.controller;

import guo.common.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/3 12:05
 */
@RestController
public class ProviderController {
    private static Map<Long, Payment> hashmap=new HashMap<>();
    static {
        hashmap.put(1L,new Payment(1L,"a"));
        hashmap.put(2L,new Payment(2L,"b"));
        hashmap.put(3L,new Payment(3L,"c"));
    }
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("get/{id}")
    public Payment getPayment(@PathVariable("id") Long id){
        Payment payment = hashmap.get(id);
        payment.setSerial(payment.getSerial()+serverPort);
        return payment;
    }
}
