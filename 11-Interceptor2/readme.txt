11-Interceptor2[多个拦截器的执行顺序]
通过修改拦截器1和拦截器2的preHandler()的返回值来实现测试

拦截器实现步骤：
1.新建maven web项目
2.加入依赖
3.创建Controller类
4.创建一个普通类，作为拦截器使用
  1）实现HandlerInterceptor接口
  2）实现接口中的三个方法
5.创建show.jsp
6.创建SpringMVC的配置文件
  1)组件扫描器 ，扫描@Controller注解
  2)声明拦截器，并指定拦截的请求uri地址