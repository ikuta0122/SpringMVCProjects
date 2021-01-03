01-HelloSpringMVC[第一个SpringMVC项目]
需求:
    1)用户在页面发起一个请求
    2)请求交给SpringMVC的控制器对象
    3)显示请求的处理结果[在结果页面显示欢迎语句]

实现步骤：
1. 新建web maven工程
2. 加入依赖
    1)spring-webmvc依赖，间接把spring的依赖都加入到项目
    2)jsp依赖
    3)servlet依赖

3.[重点]在web.xml中注册SpringMVC框架的核心对象DispatcherServlet
    1)DispatcherServlet[中央调度器]是一个Servlet
    2)DispatcherServlet继承HttpServlet
    3)DispatcherServlet也叫做前端控制器[front controller]
    4)DispatcherServlet负责接收用户提交的请求,调用其它的控制器对象并把请求的处理结果显示给用户

4.创建一个发起请求的页面 index.jsp

5.创建控制器(处理器)类
    1)在类的上面加入@Controller注解,创建对象并放入到SpringMVC容器中
    2)在类中的方法上面加入@RequestMapping注解

6.创建一个显示结果的页面 show.jsp

7.创建SpringMVC的配置文件[spring的配置文件一样]
    1)声明组件扫描器[指定@Contorller注解所在的包名]
    2)声明视图解析器[处理视图]