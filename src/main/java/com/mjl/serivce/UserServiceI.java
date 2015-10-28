package com.mjl.serivce;

import org.springframework.stereotype.Service;

/**
 * Created by Alvin on 15/10/28.
 */
@Service
public interface UserServiceI {
    public void login(String userName,String passWord);
}
