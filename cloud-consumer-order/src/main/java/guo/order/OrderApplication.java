package guo.order;

import guo.Rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/28 9:42
 */
@EnableDiscoveryClient
@SpringBootApplication
//@RibbonClient(name = "CLOUD-PAYMENT-PROVIDER",configuration = MySelfRule.class)//设置Ribbon的负载方式为随机
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
    @Bean
    //@LoadBalanced//开启ribbon负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
