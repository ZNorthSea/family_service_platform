package com.study.returnJson;

/**
 * @Auther: zhaotj
 * @Date: 2021/5/31 0031 - 05 - 31 - 19:40
 * @Description: com.study.returnJson
 * @version: 1.0
 */
public class ReturnObject {
    private Integer code = 200;
    private String message = "";
    private Object result;

    public ReturnObject() {
    }

    public ReturnObject(Object result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
