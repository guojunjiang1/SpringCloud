package guo.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/2 11:09
 */
@RestController
public class SentinelController {
    @GetMapping("test")
    public String test() {
        return "Sentinel界面是懒加载，先访问一次就出来咯";
    }
}
