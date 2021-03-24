package exception;

import entities.CommonResult;
import enums.CommonCode;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public CommonResult handler(MissingServletRequestParameterException exception){
        return new CommonResult(CommonCode.PARAM_INVALID.getCode(), exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult handler(Exception exception){
        return new CommonResult(CommonCode.FAIL.getCode(), exception.getMessage());
    }
}
