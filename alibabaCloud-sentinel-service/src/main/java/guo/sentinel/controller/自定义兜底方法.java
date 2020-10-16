package guo.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/3 11:01
 */
@RestController
public class 自定义兜底方法 {
    //当超过图形化界面的配置阈值时：
    //在图形化界面的资源名 设为SentinelResource的value时会执行自定义兜底方法errorHot
    //                   设为url路径hot时会执行sentinel自带的兜底方法
    @GetMapping("/hot")
    @SentinelResource(value = "SoHot",blockHandler = "errorHot")
    public String find(@RequestParam(value = "p",required = false) String p){
        return "没有传递热点参数，成功访问";
    }
    public String errorHot(String p, BlockException exception){
        return "由于传递热点参数，直接限流~";
    }
}
