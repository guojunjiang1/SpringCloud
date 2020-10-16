package guo.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 19:06
 */
@Service
public class HystrixService降级 {

    //指定该方法执行时间超过2s后执行failHandler方法
    @HystrixCommand(fallbackMethod = "failHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String fail(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"hystrix";
    }
    public String failHandler(){
        return Thread.currentThread().getName()+"出错了，执行该方法";
    }

    public String ok(){
        return Thread.currentThread().getName()+"hystrix";
    }
}
