package guo.account.controller;

import guo.account.service.AccountService;
import guo.common.entity.CommonResult;
import guo.common.entity.ResultCode;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/4 11:26
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("account/change")
    public CommonResult change(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money){
        boolean change = accountService.change(userId, money);
        if (change){
            return new CommonResult(ResultCode.SUCCESS);
        }else{
            return new CommonResult(ResultCode.FAIL);
        }
    }
}
