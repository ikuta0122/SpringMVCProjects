package com.ikuta.controller;

import com.ikuta.entity.Student;
import com.ikuta.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping(value = "/student")
@Controller
public class StudentController {
    //引用类型的自动注入@Autowired ,@Resource
    @Resource
    private StudentService service;

    //注册学生
    @RequestMapping(value = "/addStudent.do")
    public ModelAndView addStudent(Student student) {
        //准备用户提示信息
        String tips = "学生[" + student.getName() + "]注册失败";
        //返回视图和数据
        ModelAndView mv = new ModelAndView();
        //调用service处理student
        int nums = service.addStudent(student);
        if (nums > 0) {
            //注册成功
            tips = "学生[" + student.getName() + "]注册成功";
        }
        //添加数据
        mv.addObject("tips", tips);
        //指定结果页面
        mv.setViewName("result");
        return mv;
    }

    //处理查询,响应ajax
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent() {
        //可以进行参数检查和简单的数据处理
        return service.findStudents();
    }
}
