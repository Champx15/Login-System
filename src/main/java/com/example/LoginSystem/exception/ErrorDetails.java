package com.example.LoginSystem.exception;

public class ErrorDetails {
    private int code;
    private String status;
    private String msg;
    private Long timstamp;

    public ErrorDetails(String msg, int code, String status) {
        this.msg = msg;
        this.code = code;
        this.status = status;
        this.timstamp=System.currentTimeMillis();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Long getTimstamp() {
        return timstamp;
    }

    public void setTimstamp(Long timstamp) {
        this.timstamp = timstamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
