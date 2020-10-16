package guo.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/28 18:00
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @GetMapping("payment/find")
    public String get(){
        return "zookeeper"+port+ UUID.randomUUID().toString();
    }
}
