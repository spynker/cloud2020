package entities;

import enums.CommonCode;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CommonResult<T> implements Serializable {

    private String code;
    private String message;
    private T data;
    public CommonResult(T data) {
        this.data = data;
        this.code = CommonCode.SUCCESS.getCode();
        this.message = CommonCode.SUCCESS.getMessage();
    }

    public CommonResult(T data, String message){
        this.data = data;
        this.code = CommonCode.SUCCESS.getCode();
        this.message = message;
    }

    public CommonResult(String code, String message) {
        this(code, message, null);
    }

    public CommonResult() {
        this.code = CommonCode.FAIL.getCode();
        this.message = CommonCode.FAIL.getMessage();
    }

}
