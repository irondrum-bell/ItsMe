 package com.its.me.model;

public class ResResult {

    public static final int SUCCESS_CODE = 0x00;
    public static final int ERROR_CODE = 0x01;

    /** 결과 코드 */
    private int code = SUCCESS_CODE;

    /** 결과 메세지 */
    private String msg;

    /** 결과 값 */
    private Object value;

    public ResResult() {
        this(true);
    }

    public ResResult(boolean success) {
        this.code = success ? SUCCESS_CODE : ERROR_CODE;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getValue() {
        return value;
    }

    public ResResult setCode(int resultCode) {
        this.code = resultCode;
        return this;
    }

    public ResResult setMsg(String resultMsg) {
        this.msg = resultMsg;
        return this;
    }

    public ResResult setValue(Object resultValue) {
        this.value = resultValue;
        return this;
    }
}
