package guo.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/3 11:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderSentinelApplication.class,args);
    }
}
