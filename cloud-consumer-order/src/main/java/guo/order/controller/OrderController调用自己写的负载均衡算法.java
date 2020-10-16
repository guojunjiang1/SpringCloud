package guo.order.controller;

import guo.common.entity.CommonResult;
import guo.common.entity.Payment;
import guo.order.手写负载均衡算法.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 13:40
 */
@RestController
public class OrderController调用自己写的负载均衡算法 {
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    //自定义负载均衡轮询算法远程调用
    @GetMapping("/order/myload")
    public CommonResult create(@RequestBody Payment payment){
        //根据在eureka上生产者的名称，获取生产者的所有机器(生产者可能设置了集群)
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-provider");
        //根据自定义轮询算法，获取出这次要调用的机器
        ServiceInstance instance = loadBalancer.instances(instances);
        //获取该机器的uri地址
        URI uri = instance.getUri();
        //通过ribbon远程调用
        return  restTemplate.postForObject(uri+"/payment/create",payment,CommonResult.class);
    }
}
