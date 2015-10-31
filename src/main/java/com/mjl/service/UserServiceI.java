package com.mjl.service;

import com.mjl.model.po.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Alvin on 15/10/28.
 */

public interface UserServiceI {
    public Map<String,Object> login(String userName,String passWord);
    public User findUserByUserName(String userName);
    public  boolean checkUserName(String userName);
    public void createUser(User user);
    public void updateUserInfo(User user);
}
