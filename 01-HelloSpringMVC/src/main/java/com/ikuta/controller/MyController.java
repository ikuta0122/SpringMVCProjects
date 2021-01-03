package com.ikuta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = {"/some.do", "/first.do"})
    public ModelAndView doSome() {
        //1.获取ModelAndView对象
        ModelAndView mv = new ModelAndView();

        //2.添加数据[SpringMVC框架在将数据放入到request作用域]
        mv.addObject("msg", "欢迎使用SpringMVC做web开发");
        //相当于request.setAttribute("msg","欢迎使用SpringMVC做web开发");
        mv.addObject("fun", "执行的是doSome方法");
        //相当于request.setAttribute("fun","执行的是doSome方法");

        //3.指定视图[指定视图的完整路径]
        mv.setViewName("show");
        /*声明视图解析器之前
         *  指定视图:mv.setViewName("/WEB-INF/view/show.jsp");
         *  相当于request.getRequestDispatcher("/WEB-INF/view/show.jsp").forward(request,response);
         */
        /*声明视图解析器之后
         *  指定视图:mv.setViewName("show");
         *  SpringMVC框架根据视图解析器进行字符串拼接获取[指定视图]:前缀 + 逻辑名称[文件名] + 后缀
         *  相当于request.getRequestDispatcher("/WEB-INF/view/show.jsp").forward(request,response);
         */

        //4.返回执行结果
        return mv;
    }
}
