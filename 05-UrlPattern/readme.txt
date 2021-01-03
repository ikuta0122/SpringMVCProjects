05-UrlPattern:研究中央调度器的<url-pattern>设置为"/"
<!--处理静态资源的第一种方式
解决:SpringMVC配置文件中声明<mvc:default-servlet-handler />
原理:
    1.声明<mvc:default-servlet-handler />后,SpringMVC框架在程序内存中创建DefaultServletHandler对象
    2.DefaultServletHandler对象将[请求]转发给TomCat的default这个Servlet
注意:
    <mvc:default-servlet-handler/> 和 @RequestMapping注解 有冲突,需要在SpringMVC配置文件中声明注解驱动
-->
<!--声明<mvc:default-servlet-handler />-->
<mvc:default-servlet-handler/>
<!--声明注解驱动-->
<mvc:annotation-driven/>

<!--处理静态资源的第二种方式
解决:在SpringMVC配置文件中声明<mvc:resources/>
原理:
    1.声明<mvc:resources/>后,SpringMVC框架创建ResourceHttpRequestServlet处理器对象
    2.ResourceHttpRequestServlet处理器对象处理静态资源的访问,不依赖Tomcat服务器
属性:
    1.mapping:访问静态资源的uri地址,使用通配符[**]
    2.location:静态资源的位置
注意:
    <mvc:resources/> 和 @RequestMapping注解 有冲突,需要在SpringMVC配置文件中声明注解驱动
-->
<!--声明<mvc:resources/>-->
<mvc:resources mapping="images/**" location="/images/" />
<mvc:resources mapping="html/**" location="/html/" />
<mvc:resources mapping="js/**" location="/js/" />
<!--声明注解驱动-->
<mvc:annotation-driven/>
<!--一条配置处理所有静态资源-->
<mvc:resources mapping="static/**" location="/static/" />
