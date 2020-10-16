package guo.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 9:14
 */
@RestController
public class ConsulController {
    @Value("${server.port}")
    private String port;
    @GetMapping("payment/find")
    public String get(){
        return "zookeeper"+port+ UUID.randomUUID().toString();
    }
}
