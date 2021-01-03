package com.ikuta.controller;

import com.ikuta.exception.AgeException;
import com.ikuta.exception.MyUserException;
import com.ikuta.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = "/some.do")
    public ModelAndView some(String name, Integer age) throws MyUserException {
        ModelAndView mv = new ModelAndView();
        //根据请求参数抛出异常
        if("".equals(name.trim())){
            throw new NameException("姓名不正确");
        }
        if (age == null || age < 18){
            throw new AgeException("年龄不正确");
        }
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }
}
