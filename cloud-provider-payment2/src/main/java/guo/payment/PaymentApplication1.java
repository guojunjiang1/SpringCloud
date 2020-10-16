package guo.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/27 18:16
 */

@SpringBootApplication
@MapperScan("guo.payment.dao")
@EnableEurekaClient
public class PaymentApplication1 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication1.class,args);
    }
}
