package guo.nacos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/1 20:09
 */
@FeignClient("nacos-payment-provider")
public interface PaymentClients {
    @GetMapping("payment/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id);
}

