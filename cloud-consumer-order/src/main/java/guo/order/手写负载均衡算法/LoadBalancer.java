package guo.order.手写负载均衡算法;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 11:52
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> list);
}
