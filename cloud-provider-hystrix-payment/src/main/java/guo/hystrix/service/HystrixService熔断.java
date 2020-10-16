package guo.hystrix.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/30 10:55
 */

@Service
public class HystrixService熔断 {
    //服务熔断：当调用方法失败时，执行降级方法，若在10S内发出的10次请求有6次失败就启动熔断策略，当调用方法成功且达到一定次数后，取消熔断策略，恢复正常链路调用
    //服务降级：当调用方法失败时，执行编写的降级方法(服务熔断包括服务降级)
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {// 指定降级的方法
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后启动熔断
    })
    public String paymentCircuitBreaker(Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
