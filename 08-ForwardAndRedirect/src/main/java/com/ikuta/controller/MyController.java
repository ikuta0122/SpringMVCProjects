package com.ikuta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    /*处理器方法返回ModelAndView,实现转发Forward
    1.语法机制:mv.setViewName("forward:视图文件完成路径");
    2.特点:不和视图解析器一同工作,相当于项目中没有视图解析器
    3.作用:将请求转发到视图解析器指定文件夹之外的页面
    */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doForward(String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        //以下请求转发方式称为:"显示转发"
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }

    /*处理器方法返回ModelAndView,实现重定向Redirect
    1.语法机制:mv.setViewName("redirect:视图文件完成路径");
    2.特点:不和视图解析器一同工作,相当于项目中没有视图解析器
    3.作用:在两次请求之间进行传递数据
    4.在目标页面获取请求参数值
        使用参数集合对象param
        语法格式:${param.参数名}
    5.注意
        1)重定向不能访问WEB-INF文件夹下的资源
        2)重定向后的页面不能获取参数值的原因:进行了两次request导致request作用域不同
    */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doRedirect(String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        //以下请求重定向方式称为:""
        mv.setViewName("redirect:/result.jsp");
        //地址:http://localhost:8080/08_RequestAndRedirect_war_exploded/result.jsp?myname=lisi&myage=50
        //解读:SpringMVC框架将Model中的简单类型数据转换为String类型,作为hello.jsp的get请求参数使用
        //目的:在请求1[doRedirect.do]和请求2[result.jsp]之间传递数据
        return mv;
    }

}
