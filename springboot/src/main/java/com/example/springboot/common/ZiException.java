package com.example.springboot.common;/**
 * #date：2020/11/9 <br/>
 * #param:  <br/>
 * #return: <br/>
 */
public class ZiException  extends  RuntimeException{
    private String code;
    private String msg = "";
    private String sysMsg = "";

    public ZiException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ZiException(String code, String msg, String sysMsg) {
        this.code = code;
        this.msg = msg;
        this.sysMsg = sysMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSysMsg() {
        return sysMsg;
    }

    public void setSysMsg(String sysMsg) {
        this.sysMsg = sysMsg;
    }
}
