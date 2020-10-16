package guo.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import guo.common.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/3 12:22
 */
//远程调用通过ribbon的方式
@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("ribbon/{id}")
    @SentinelResource(value = "guo",fallback = "error",blockHandler = "error2")
    public Payment get(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://alibabaCloud-sentinel-provider/get/"+id,Payment.class);
    }
    public Payment error(@PathVariable("id") Long id){
        return new Payment(1L,"远程调用出现异常");
    }
    public Payment error2(@PathVariable("id") Long id, BlockException exception){
        return new Payment(1L,"error");
    }

}
