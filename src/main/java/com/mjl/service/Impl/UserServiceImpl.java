package com.mjl.service.Impl;

import com.mjl.Util.Constant;
import com.mjl.dao.UserDaoI;
import com.mjl.model.po.User;
import com.mjl.service.UserServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alvin on 15/10/28.
 */
@Service
public class UserServiceImpl implements UserServiceI{
    @Resource
    UserDaoI userDaoI;


    public Map<String, Object> login(String userName, String passWord) {
        Map<String,Object> result = new HashMap<String, Object>();
        User user = userDaoI.findUserByUserName(userName);
        if(null == user && user.getUserPassWord().equals(passWord)){
            result.put("status", Constant.USER_LOGIN_ERROR);
            result.put("message","用户名或密码错误!");
        }else{
            result.put("status",Constant.USER_LOGIN_SUCCESS);
            result.put("message","登录成功!");
        }
        return result;
    }

    public User findUserByUserName(String userName) {
       return userDaoI.findUserByUserName(userName);
    }
}
