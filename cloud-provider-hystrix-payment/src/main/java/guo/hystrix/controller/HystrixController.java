package guo.hystrix.controller;

import guo.hystrix.service.HystrixService熔断;
import guo.hystrix.service.HystrixService降级;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 19:10
 */
@RestController
public class HystrixController {
    @Autowired
    private HystrixService降级 hystrixService;
    @Autowired
    private HystrixService熔断 hystrixService1;
    @GetMapping("provider/get")
    public String get(){
        return hystrixService.fail();
    }

    @GetMapping("provider/get/ok")
    public String getOk(){
        return hystrixService.ok();
    }

    @GetMapping("provider/get/{id}")
    public String getfail(@PathVariable Integer id){
        return hystrixService1.paymentCircuitBreaker(id);
    }
}
