package guo.hystrix.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 19:58
 */
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-PROVIDER",fallback = ProviderClientHandler.class)
public interface ProviderClient {
    @GetMapping("provider/get")
    String get();

    @GetMapping("provider/get/ok")
    String getOk();
}
