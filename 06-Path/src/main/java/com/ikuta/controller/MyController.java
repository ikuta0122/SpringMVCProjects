package com.ikuta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @RequestMapping: value ： 所有请求地址的公共部分，叫做模块名称
 * 位置： 放在类的上面
 */
@Controller
public class MyController {
    @RequestMapping(value = "/user/some.do")
    public ModelAndView doSome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用SpringMVC做web开发");
        mv.addObject("fun", "执行的是doSome方法");
        mv.setViewName("show");
        return mv;
    }

}
