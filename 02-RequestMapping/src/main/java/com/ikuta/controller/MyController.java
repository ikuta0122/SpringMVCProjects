package com.ikuta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @RequestMapping: value ： 所有请求地址的公共部分，叫做模块名称
 * 位置： 放在类的上面
 */
@Controller
@RequestMapping(value = "/user")
public class MyController {
    //指定some.do和first.do使用GET请求方式
    @RequestMapping(
            value = {"/some.do", "/first.do"},
            method = RequestMethod.GET
    )
    public ModelAndView doSome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用SpringMVC做web开发");
        mv.addObject("fun", "执行的是doSome方法");
        mv.setViewName("show");
        return mv;
    }

    //指定other.do和second.do使用POST请求方式
    @RequestMapping(
            value = {"/other.do", "/second.do"},
            method = RequestMethod.POST
    )
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用SpringMVC做web开发");
        mv.addObject("fun", "执行的是doOther方法");
        mv.setViewName("other");
        return mv;
    }
}
