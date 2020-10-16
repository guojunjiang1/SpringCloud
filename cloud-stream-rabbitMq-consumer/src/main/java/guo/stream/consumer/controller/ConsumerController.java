package guo.stream.consumer.controller;

import guo.stream.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/1 10:16
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;
    @GetMapping("send")
    public String  sendMessage(){
      return consumerService.send();
    }
}
