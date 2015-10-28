package com.mjl.serivce.Impl;

import com.mjl.dao.UserDaoI;
import com.mjl.serivce.UserServiceI;

import javax.annotation.Resource;

/**
 * Created by Alvin on 15/10/28.
 */
public class UserServiceImpl implements UserServiceI{
    @Resource
    UserDaoI userDaoI;

    public void login(String userName, String passWord) {
        
    }
}
