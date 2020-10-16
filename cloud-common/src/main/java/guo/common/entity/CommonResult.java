package guo.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/27 18:45
 */
@Data
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(ResultCode resultCode){
        this(resultCode,null);
    }
    public CommonResult(ResultCode resultCode,T data){
        this.code=resultCode.Code();
        this.message=resultCode.Message();
        this.data=data;
    }
}
