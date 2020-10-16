package guo.stream.consumer.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;
import java.util.UUID;
/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/1 10:17
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class ConsumerService {

    @Resource
    private MessageChannel output; // 消息发送管道

    public String send()
    {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());//发送消息
        System.out.println("*****serial: "+serial);
        return null;
    }
}
