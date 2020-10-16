package guo.seata.client;

import guo.common.entity.CommonResult;
import guo.common.entity.ResultCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 11:28
 */
@FeignClient(value = "seata-account-service",fallback = AccountClientException.class)
public interface AccountClient {
    @PostMapping("account/change")
    CommonResult change(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
