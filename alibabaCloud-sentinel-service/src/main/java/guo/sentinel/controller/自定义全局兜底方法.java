package guo.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import guo.common.entity.CommonResult;
import guo.common.entity.ResultCode;
import guo.sentinel.handler.MyHandlerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/3 11:03
 */
@RestController
public class 自定义全局兜底方法 {


    //由于局部的兜底方法和代码耦合度太高，使用全局兜底方法
    @SentinelResource(value = "test",blockHandlerClass = MyHandlerException.class,blockHandler = "error1")
    @GetMapping("guo")
    public CommonResult<String> get(){
        return new CommonResult<>(ResultCode.SUCCESS,"访问成功");
    }
}
