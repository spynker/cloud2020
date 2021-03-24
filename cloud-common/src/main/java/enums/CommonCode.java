package enums;

public enum CommonCode {

    SUCCESS("0000", "执行成功"),
    FAIL("9999", "执行失败"),
    PARAM_INVALID("9998", "参数错误");

    CommonCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
