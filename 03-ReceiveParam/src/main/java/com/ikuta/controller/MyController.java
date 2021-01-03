package com.ikuta.controller;

import com.ikuta.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    //接收用户提交的请求参数
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView receiveProperty(String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }

    //处理器方法形参名和请求参数名不一致,使用注解@RequestParam解决
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveParam(
            @RequestParam(value = "othername", required = false) String name,
            @RequestParam(value = "otherage", required = false) Integer age
    ) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }

    //使用java对象接收请求参数
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveObject(Student student) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("mystudent", student);
        mv.addObject("myname", student.getName());
        mv.addObject("myage", student.getAge());
        mv.setViewName("other");
        return mv;
    }
}
