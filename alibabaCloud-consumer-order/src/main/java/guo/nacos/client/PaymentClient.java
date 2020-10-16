package guo.nacos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 17:34
 */
@FeignClient("cloud-payment-provider")
public interface PaymentClient {
    @PostMapping("payment/create")
    void create();
}
