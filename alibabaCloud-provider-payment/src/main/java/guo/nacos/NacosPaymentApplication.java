package guo.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/1 19:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentApplication.class,args);
    }
}
