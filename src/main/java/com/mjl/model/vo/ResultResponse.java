package com.mjl.model.vo;

/**
 * Created by Alvin on 15/10/29.
 *
 * 用于与前台进行数据交互
 */


public class ResultResponse {
    //结果状态:0:失败 1.成功
    private int status;
    //用于返回的信息,在前端显示
    private String message;
    //用于返回需要传递给用户的信息
    private Object date;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public ResultResponse(int status, String message, Object date) {
        this.status = status;
        this.message = message;
        this.date = date;
    }

    public ResultResponse(Object o){

    }
}
