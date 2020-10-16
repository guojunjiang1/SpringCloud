package guo.Rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 10:54
 */
//设置负载均衡算法
@Configuration
public class MySelfRule {
    @Bean
    public IRule rule(){
        return new RandomRule();//定义负载方式为；随机
    }
}
