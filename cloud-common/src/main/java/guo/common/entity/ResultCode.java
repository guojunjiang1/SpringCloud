package guo.common.entity;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/27 19:22
 */
public enum  ResultCode {
    SUCCESS(200,"操作成功"),FAIL(444,"操作失败");
    private Integer code;
    private String message;

    ResultCode(int code, String message) {
        this.code=code;
        this.message=message;
    }

    public Integer Code() {
        return code;
    }

    public String Message() {
        return message;
    }
}
