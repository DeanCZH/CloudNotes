package com.mjl.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alvin on 15/11/15.
 */
public class PageFilter extends HttpServlet implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取文件的上下文
        String requestUri = request.getRequestURI();        //获取当前连接名字
        String Path = request.getContextPath();
        String basePath= request.getScheme()+"://"+request.getServerName()+":"
                +request.getServerPort()+Path+"/";
        String[] noFilter = new String[]{"login.html","/js/user/user.js","/user/login.do"};
        boolean beFilter = true;
        for(String s:noFilter){
            System.out.println(requestUri);
            if(requestUri.indexOf(s)!=-1){
                System.out.println("===============不需要拦截的对象=============");
                beFilter = false;
                break;
            }
        }
        if(beFilter == true) {
            HttpSession session = request.getSession(true);
            String userName = (String) session.getAttribute("userName");
            System.out.println(userName);

            if (userName == null || userName.equals("")) {
                System.out.println("跳转");
                response.sendRedirect(basePath+"login.html");
            }
        }
        filterChain.doFilter(request, response);
    }
}
