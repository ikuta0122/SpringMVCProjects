package com.ikuta.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikuta.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    //处理器方法的返回值类型为String,表示逻辑视图名称[需要配置视图解析器]
    @RequestMapping(value = "/returnString-view1.do")
    public String returnString1(HttpServletRequest request, String name, Integer age) {
        //添加数据到request作用域
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);
        //SpringMVC框架对视图进行forward转发操作
        //返回逻辑视图名称
        return "show";
    }

    //处理器方法的返回值类型为String,表示完整视图路径[不能配置视图解析器]
    @RequestMapping(value = "/returnString-view2.do")
    public String returnString2(HttpServletRequest request, String name, Integer age) {
        //添加数据到request作用域
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);
        //返回逻辑视图名称,SpringMVC框架对视图进行forward转发操作
        return "/WEB-INF/view/show.jsp";
    }

    //处理器方法返回void,响应ajax请求
    //手动实现AJAX和返回JSON格式的字符串的缺点:步骤2和3具有大量的重复代码
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void returnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        //1.调用service()方法,使用Student表示处理结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        //2.结果对象转换为JSON格式的字符串
        String json = "";
        if (name != null && age != null) {
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
        }
        //3.输出数据,响应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }

    //使用注解@ResponseBody将引用类型对象转换为JSON格式的字符串
    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student returnStudentJson(String name, Integer age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }

    //使用注解@ResponseBody将集合数组对象转换为JSON格式的字符串
    @RequestMapping(value = "/returnListJson.do")
    @ResponseBody
    public List<Student> returnListJson(String name, Integer age) {
        //准备数据
        Student student1 = new Student();
        student1.setName(name + 1);
        student1.setAge(age + 1);
        Student student2 = new Student();
        student2.setName(name + 2);
        student2.setAge(age + 2);
        //向List中添加元素
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        return list;
    }

    //使用注解@ResponseBody返回String对象
    //中文乱码解决:设置属性produces = "text/plain;charset=utf-8"
    //默认属性produces = "text/plain;charset=ISO-8859-1"
    @RequestMapping(value = "/returnString.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String returnString(String name, Integer age) {
        return "[姓名" + name + ",年龄" + age + "]";
    }

}
