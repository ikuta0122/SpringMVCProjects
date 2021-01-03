package com.ikuta.handler;

import com.ikuta.exception.AgeException;
import com.ikuta.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
@ControllerAdvice
1.作用:控制器增强[增加功能:异常处理功能]
2.位置:类的上面
3.注意:需要在SpringMVC配置文件声明组件扫描器,指定@ControllerAdvice注解所在包名
*/
@ControllerAdvice
public class GlobalExceptionHandler {
    //异常处理器方法的形参[Exception exception]表示Controller中抛出的异常对象
    //@ExceptionHandler 表示异常的类型,即当发生此类型异常时由当前方法处理

    //处理NameException
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "姓名不能为空");
        mv.addObject("ex", exception);
        mv.setViewName("nameError");
        return mv;
    }


    //处理AgeException
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "未成年禁止访问");
        mv.addObject("ex", exception);
        mv.setViewName("ageError");
        return mv;
    }

    //处理其它异常
    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", " ");
        mv.addObject("ex", exception);
        mv.setViewName("defaultError");
        return mv;
    }
}
