package com.ikuta.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//拦截器类:拦截用户请求
public class MyInterceptor implements HandlerInterceptor {
    //计算拦截器接收请求开始执行到请求处理结束的时间
    private long beginTime = 0;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        System.out.println("执行MyInterceptor的preHandle()方法");
        beginTime = System.currentTimeMillis();
        //preHandle()方法中应当有业务的计算逻辑:根据计算结果,返回true/false
        //给浏览器一个返回结果:request.getRequestDispatcher("/tips.jsp").forward(request, response);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("执行MyInterceptor的postHandle()方法");
        //对原来some()方法的执行结果进行调整
        if (modelAndView != null) {
            //修改数据
            modelAndView.addObject("mydate", new Date());
            //修改视图
            modelAndView.setViewName("other");
        }
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) throws Exception {
        System.out.println("执行MyInterceptor的afterCompletion()方法");
        long endTime = System.currentTimeMillis();
        System.out.println("计算拦截器接收请求开始执行到请求处理结束的时间:" + (endTime - beginTime));
    }
}
