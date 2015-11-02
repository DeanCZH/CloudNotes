package com.mjl.controller;

import com.mjl.Util.Constant;
import com.mjl.model.po.User;
import com.mjl.model.vo.ResultResponse;
import com.mjl.service.UserServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by Alvin on 15/10/29.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    UserServiceI userServiceI;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse userLogin(String userName,String userPassWord,HttpServletRequest request,HttpSession session){
        Map<String,Object> result = userServiceI.login(userName,userPassWord);
        if(result.get("status").equals(1)){
            User dbuser = userServiceI.findUserByUserName(userName);
            dbuser.setUserLastIp(request.getRemoteAddr());
            dbuser.setUserLastLoginTime(new Timestamp(new Date().getTime()));
            userServiceI.updateUserInfo(dbuser);
            session.setAttribute("user", dbuser);
            result.put("user", dbuser);
        }
        ResultResponse res = new  ResultResponse((Integer) result.get("status"),(String)result.get("message"),result.get("user"));
        System.out.println(res.toString());
        return res;
    }


    @RequestMapping(value = "/register",method =  RequestMethod.POST)
    @ResponseBody
    public ResultResponse register(User user) {
        ResultResponse res = new ResultResponse();
        String dbUserName = user.getUserName();
        if(!userServiceI.checkUserName(dbUserName)){
            res.setStatus(Constant.USER_REGISTER_ERROR);
            res.setMessage("用户名已存在");
            System.out.println("用户名存在");
            return res;
        }
        userServiceI.createUser(user);
        res.setStatus(Constant.USER_REGISTER_SUCCESS);
        res.setMessage("恭喜你!注册成功");
        return res;
    }

    @RequestMapping(value = "/logout" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse logout(HttpSession session){
        session.invalidate();
        return new ResultResponse(1,"退出成功",null);
    }

}
