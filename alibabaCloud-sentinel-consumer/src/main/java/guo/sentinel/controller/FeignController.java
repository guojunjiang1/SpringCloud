package guo.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import guo.common.entity.Payment;
import guo.sentinel.client.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/3 17:06
 */
@RestController
public class FeignController {
    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping("feign/{id}")
    public Payment get(@PathVariable("id") Long id){
        return providerFeign.getPayment(id);
    }
    public Payment error(@PathVariable("id") Long id, BlockException exception){
        return new Payment(1L,"熔断");
    }
}
