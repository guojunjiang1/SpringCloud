package guo.seata.service;

import guo.common.entity.CommonResult;
import guo.seata.client.AccountClient;
import guo.seata.client.StorageClient;
import guo.seata.dao.OrderDao;
import guo.seata.domain.Order;
import io.seata.spring.annotation.GlobalTransactional;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 10:55
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountClient accountClient;
    @Autowired
    private StorageClient storageClient;

    //开启分布式事务
    @GlobalTransactional(name = "guo",rollbackFor = Exception.class)
    public boolean come(Order order){
        System.out.println("创建订单");
        //新建订单
        int i = orderDao.create(order);
        //远程调用扣减余额
        CommonResult result = accountClient.change(order.getUserId(), order.getMoney());
        System.out.println("扣减余额");
        //远程调用扣减账户库存
        CommonResult result2 = storageClient.change(order.getProductId(), order.getCount());
        System.out.println("扣减库存");
        //修改订单状态
        System.out.println("修改状态");
        orderDao.changeStatus(order.getUserId(),1);
        return result.getCode()==200&&i>0&&result2.getCode()==200;
    }
}
