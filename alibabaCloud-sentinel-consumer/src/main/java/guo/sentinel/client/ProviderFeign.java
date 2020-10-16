package guo.sentinel.client;

import guo.common.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/3 17:05
 */
@FeignClient(value = "alibabaCloud-sentinel-provider",fallback = ProviderFeignError.class)
public interface ProviderFeign {
    @GetMapping("get/{id}")
    Payment getPayment(@PathVariable("id") Long id);
}
