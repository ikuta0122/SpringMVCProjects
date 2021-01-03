package com.ikuta.handler;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器类:拦截用户请求
public class MyInterceptor implements HandlerInterceptor {

    //验证登录的用户信息
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        //从session中获取name的值
        String loginName = "";
        Object attr = request.getSession().getAttribute("name");
        if (attr != null) {
            loginName = (String) attr;
        }
        //判断登录账号是否符合要求
        if (!"zs".equals(loginName)) {
            //当登录账号不符合要求时,提示用户
            request.getRequestDispatcher("/tips.jsp").forward(request, response);
            return false;
        }
        return true;
    }
}
