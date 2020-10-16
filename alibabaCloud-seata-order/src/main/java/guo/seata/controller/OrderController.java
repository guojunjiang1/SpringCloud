package guo.seata.controller;

import guo.common.entity.CommonResult;
import guo.common.entity.ResultCode;
import guo.seata.domain.Order;
import guo.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 10:55
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("test")
    public CommonResult get(){
        Order order=new Order();
        order.setProductId(1L);
        order.setStatus(0);
        order.setCount(1);
        order.setMoney(BigDecimal.valueOf(100));
        order.setUserId(1L);
        boolean come = orderService.come(order);
        if (come){
            return new CommonResult(ResultCode.SUCCESS);
        }else {
            return new CommonResult(ResultCode.FAIL);
        }
    }
}
