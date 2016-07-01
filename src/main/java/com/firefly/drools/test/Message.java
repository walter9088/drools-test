package com.firefly.drools.test;

/**
 * 类Message.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年6月8日 下午3:39:05
 */
public class Message {

    public static final int HELLO   = 0;
    public static final int GOODBYE = 1;

    private String          info;
    private int             status;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
