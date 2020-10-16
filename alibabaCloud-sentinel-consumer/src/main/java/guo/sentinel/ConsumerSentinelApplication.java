package guo.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/3 12:21
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerSentinelApplication.class,args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
