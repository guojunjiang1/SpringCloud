package guo.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/28 18:00
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZookeeperApplication.class,args);
    }
}
