package com.mjl.dao;

import com.mjl.model.User;

/**
 * Created by Alvin on 15/10/28.
 */

public interface UserDaoI {
    public User findUserByUserName(String userName);
    public void addUser(User user);
    public void deleteUserByUserName(String userName);
    public void updateUserByUserName(User user);
}
