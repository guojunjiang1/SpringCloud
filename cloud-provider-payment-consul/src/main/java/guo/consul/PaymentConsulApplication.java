package guo.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 9:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulApplication.class,args);
    }
}
