package guo.seata.client;

import guo.common.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 12:10
 */
@FeignClient(value = "seata-storage-service")
public interface StorageClient {
    @PostMapping("storage/change")
    CommonResult change(@RequestParam("productId") Long productId, @RequestParam("number") Integer number);
}
