package com.mjl.aop;


import com.mjl.Util.LogFileWrite;
import com.mjl.model.vo.ResultResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alvin on 15/11/14.
 */
@Aspect
@Component
public class logAop {

    LogFileWrite logFileWrite = new LogFileWrite();
    //用户登录信息
    @Before("execution(* com.mjl.controller.UserController.userLogin(..))")
    public void beforelogUserLogInfo(JoinPoint jp) throws Throwable{
        System.out.println("登录");
       Object[] args =jp.getArgs();
        String userName = args[0].toString();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date now = new Date();
        logFileWrite.writer("==================用户登录================="+"\r\n");
        logFileWrite.writer("用户名:"+userName+"   登录时间:"+sdf.format(now)+"\r\n");

    }
    //用户是否登录成功信息
    @AfterReturning(returning = "o",pointcut = "execution(* com.mjl.controller.UserController.userLogin(..))")
    public void afterlogUserLogInfo(Object o) throws Throwable{

        ResultResponse rs = (ResultResponse)o;
        logFileWrite.writer("登录结果:"+rs.getMessage()+"\r\n");
        logFileWrite.writer("=========================================="+"\r\n");
    }
}
