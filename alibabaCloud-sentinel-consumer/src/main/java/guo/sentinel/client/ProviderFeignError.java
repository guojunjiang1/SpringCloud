package guo.sentinel.client;

import guo.common.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/3 17:06
 */
@Component
public class ProviderFeignError implements ProviderFeign{
    @Override
    public Payment getPayment(Long id) {
        return new Payment(1L,"feign降级方法");
    }
}
