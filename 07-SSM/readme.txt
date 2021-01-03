07-SSM[SSM整合开发:SpringMVC + Spring + MyBatis]
SpringMVC[视图层/界面层]:负责接收请求，显示处理结果
Spring[业务层]:负责管理service,dao,工具类对象
MyBatis[持久层]:访问数据库

SSM流程示意:
    --->用户发起请求
    --->SpringMVC接收请求
    --->Spring中的Service对象
    --->MyBatis处理数据

SSM的实现原理
    1)第一个容器SpringMVC容器[管理Controller控制器对象]
        Controller对象和web开发的相关对象交给SpringMVC容器,定义在SpringMVC配置文件中
    2)第二个容器Spring容器[管理Service,Dao,工具类对象]
        service对象和dao对象交给Spring容器,定义在Spring的配置文件中
    3)SpringMVC容器是Spring容器的子容器,类似java中的继承[子可以访问父的内容]
         实现在子容器中的Controller访问父容器中的Service对象
         进而实现controller对象使用service对象

实现步骤：
0.使用mysql的springdb库,表使用student(id auto_increment,name,age)
1.新建maven web项目
2.加入依赖
    1)SpringMVC依赖
    2)Spring依赖
    3)MyBatis依赖
    4)jackson依赖
    5)mysql驱动依赖
    6)druid连接池依赖
    7)jsp依赖
    8)servlet依赖
3.写web.xml
    1)注册DispatcherServlet
        1.创建SpringMVC容器对象，才能创建Controller类对象。
        2.创建的是Servlet，才能接受用户的请求。
    2)注册Spring的监听器：ContextLoaderListener
        创建Spring的容器对象，才能创建service，dao等对象。
    3)注册字符集过滤器，解决post请求乱码的问题
4.创建包
    1)Controller包
    2)service包
    3)dao包
    4)实体类包
5.写配置文件
    1)SpringMVC配置文件
    2)Spring配置文件
    3)MyBatis主配置文件
    4)数据库的属性配置文件

6.写代码
    1)dao接口及其mapper文件
    2)service接口及其实现类
    3)controller类
    4)实体类

7.写jsp页面