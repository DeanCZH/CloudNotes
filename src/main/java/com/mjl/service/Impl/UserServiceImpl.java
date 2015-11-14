package com.mjl.service.Impl;

import com.mjl.Util.Constant;
import com.mjl.dao.UserDaoI;
import com.mjl.model.po.User;
import com.mjl.service.UserServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alvin on 15/10/28.
 */
@Service
public class UserServiceImpl implements UserServiceI{
    @Resource
    UserDaoI userDaoI;

    //更新用户信息
    public void updateUserInfo(User user){
        userDaoI.updateUserByUserName(user);
    }


    //检查用户名是否存在
    public  boolean checkUserName(String userName){
        if(null == userName && "".equals(userName)){
            return false;
        }else{
            if(userDaoI.findUserByUserName(userName) == null){
                return true;
            }
            return false;
        }

    }

    //用户登录
    public Map<String, Object> login(String userName, String passWord) {
        Map<String,Object> result = new HashMap<String, Object>();
        User user = userDaoI.findUserByUserName(userName);
        System.out.println("equals:"+user.getUserPassWord().equals(passWord));
        if( user.getUserPassWord().equals(passWord)){
            result.put("status",Constant.USER_LOGIN_SUCCESS);
            result.put("message","登录成功!");
        }else{
            result.put("status", Constant.USER_LOGIN_ERROR);
            result.put("message","用户名或密码错误!");
        }
        System.out.println("service");
        return result;
    }

    public User findUserByUserName(String userName) {

        return userDaoI.findUserByUserName(userName);
    }

    public void createUser(User user) {
        User dbuser = user;
        user.setUserCreateTime(new Timestamp(new Date().getTime()));
        userDaoI.addUser(user);
    }

}
