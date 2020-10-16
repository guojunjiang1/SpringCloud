package guo.stream.provider.listen;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/1 10:40
 */
@Component
@EnableBinding(Sink.class)
public class ListenMq {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("接收到消息"+message.getPayload());
    }
}
