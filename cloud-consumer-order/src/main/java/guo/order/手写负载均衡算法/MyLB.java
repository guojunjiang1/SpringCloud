package guo.order.手写负载均衡算法;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/29 11:52
 */
//手写轮询算法
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger=new AtomicInteger();
    //计算出当前的访问次数
    public int get(){
        int current;//之前访问的次数
        int next;//当前的次数
        //自旋锁，可能有多个线程访问
        while (true){
            current=atomicInteger.get();
            next=current==2147483647 ? 0:current+1;//如果访问次数达到int最大值则重新计数
            boolean b = atomicInteger.compareAndSet(current, next);
            if (b){
                return next;
            }
        }
    }
    
    //计算出应该由哪个客户端来被调用
    @Override
    public ServiceInstance instances(List<ServiceInstance> list) {
        int size = list.size();
        if (size==0){
            return null;
        }
        int num = get();
        return list.get(num%size);
    }
}
