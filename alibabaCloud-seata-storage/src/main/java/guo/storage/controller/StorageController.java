package guo.storage.controller;

import guo.common.entity.CommonResult;
import guo.common.entity.ResultCode;
import guo.storage.service.StorageService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 12:07
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;
    @PostMapping("storage/change")
    public CommonResult change(@RequestParam("productId") Long productId,@RequestParam("number") Integer number){
        boolean change = storageService.change(productId, number);
        if (change){
            return new CommonResult(ResultCode.SUCCESS);
        }else {
            return new CommonResult(ResultCode.FAIL);
        }
    }
}
