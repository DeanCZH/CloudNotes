package com.mjl.controller;

import com.mjl.model.po.User;
import com.mjl.model.vo.ResultResponse;
import com.mjl.service.UserServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    public ResultResponse userLogin(String userName,String passWord,HttpSession httpSession){
        System.out.println("1");
        Map<String,Object> result = userServiceI.login(userName,passWord);
        System.out.println("status:"+result.get("status"));
        System.out.println("message:"+result.get("message"));
        if(result.get("status").equals(1)){
            System.out.println(2);
            User user = userServiceI.findUserByUserName(userName);
            result.put("result",user);
        }
        return new ResultResponse((Integer) result.get("status"),(String)result.get("message"),result.get("reslut"));
    }
}
