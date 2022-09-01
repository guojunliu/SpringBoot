package com.example.demo.respones;

public class HttpResponse {

    private int code;
    private Object data;
    private  boolean success;

    private String message;

    public HttpResponse() {
        this.message = "";
    }
    public HttpResponse(int code, Object data, boolean success) {
        this.code = code;
        this.data = data;
        this.success = success;
        this.message = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
