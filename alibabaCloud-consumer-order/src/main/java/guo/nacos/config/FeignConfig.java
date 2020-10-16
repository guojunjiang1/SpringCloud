package guo.nacos.config;

import feign.Logger;
import guo.nacos.client.PaymentClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 17:47
 */
//设置打印feign远程调用的日志
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
