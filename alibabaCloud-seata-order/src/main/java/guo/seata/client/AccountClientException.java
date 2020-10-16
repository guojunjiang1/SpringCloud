package guo.seata.client;

import guo.common.entity.CommonResult;
import guo.common.entity.ResultCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/10/10 10:39
 */
@Component
public class AccountClientException implements AccountClient{
    @Override
    public CommonResult change(Long userId, BigDecimal money) {
        System.out.println("MQ对余额进行补偿，不对总业务造成影响");
        return new CommonResult(ResultCode.SUCCESS);
    }
}
