package guo.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/1 20:02
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class NacosOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderApplication.class,args);
    }
}
