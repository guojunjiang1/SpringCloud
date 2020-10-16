package guo.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import guo.common.entity.CommonResult;
import guo.common.entity.ResultCode;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/6/3 11:09
 */
public class MyHandlerException {

    public static CommonResult error(BlockException exception){
        return new CommonResult<String>(ResultCode.FAIL,"目前正在降级");
    }
    public static CommonResult error1(BlockException exception){
        return new CommonResult<String>(ResultCode.FAIL,"目前正在限流");
    }
}
