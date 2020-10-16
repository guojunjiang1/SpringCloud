package guo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/28 10:45
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka1Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1Application.class,args);
    }
}
