package guo.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/31 9:30
 */
@RestController
@RefreshScope
public class ConfigController {

    //通过配置中心从github上获取到的配置内容
    @Value("${config.info}")
    private String Info;

    @GetMapping("config")
    public String get(){
        return Info;
    }
}
