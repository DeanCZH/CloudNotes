package com.mjl.model.po;

import sun.rmi.runtime.Log;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Alvin on 15/10/27.
 */
public class User implements Serializable{
    private int userId;
    private String userName;
    private String userPassWord;
    private String userEmail;
    private String userPhone;
    private Timestamp userCreateTime;
    private Timestamp userLastLoginTime;
    private String userLastIp;

    /*
    user与note为一对多的关系
     */

    private List<Note> notes;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Timestamp getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Timestamp userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public String getUserLastIp() {
        return userLastIp;
    }

    public void setUserLastIp(String userLastIp) {
        this.userLastIp = userLastIp;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userCreateTime=" + userCreateTime +
                ", userLastLoginTime=" + userLastLoginTime +
                ", userLastIp='" + userLastIp + '\'' +
                ", notes=" + notes +
                '}';
    }
}
