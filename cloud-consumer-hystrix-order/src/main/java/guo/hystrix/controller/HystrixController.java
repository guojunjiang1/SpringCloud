package guo.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import guo.hystrix.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 20:01
 */
@RestController
@DefaultProperties(defaultFallback = "allFail")//指定全局的降级方法
public class HystrixController {
    @Autowired
    private ProviderClient providerClient;

    //指定远程调用时超过1s或出错 则执行failHandler方法(局部降级)
    @HystrixCommand(fallbackMethod = "failHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    @GetMapping("consumer/hystrix/get")
    public String getFail(){
        return providerClient.get();
    }
    public String failHandler(){
        return "远程调用出错~";
    }

    @HystrixCommand//配置进全局降级
    @GetMapping("consumer/hystrix/getok")
    public String get(){
        return providerClient.getOk();
    }

    public String allFail(){
        return "全局降级方法~";
    }
}
