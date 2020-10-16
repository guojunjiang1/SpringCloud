package guo.hystrix.client;

import org.springframework.stereotype.Component;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/30 10:48
 */
@Component
public class ProviderClientHandler implements ProviderClient{
    @Override
    public String get() {
        return "feign的降级方法";
    }

    @Override
    public String getOk() {
        return "feign的降级方法";
    }
}
